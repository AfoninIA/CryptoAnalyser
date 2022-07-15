package ru.javarush.cryptoanalyser.afonin.util;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;


public class Analyser {
    private static final int SPACE_IN_1000_SYMBOLS = 174;
    private static Map<Character, Double> frequencySymbolsInDict;

    public static boolean isText(List<String> analysedText){
        throw new UnsupportedOperationException();
    }

    public static Map<Character, Double> getFrequencySymbols(List<String> text){
        Map<Character, Double> result = new HashMap<>();
        text.stream()
                .map(String::toLowerCase)
                .flatMapToInt(String::chars)
                .mapToObj(i -> (char)i)
                .forEach(key -> result.put(key, result.getOrDefault(key, 0d) + 1));

        double sumAllSymbols = result.values().stream().mapToDouble(i -> i).sum();
        result.replaceAll((key, value) -> (value / sumAllSymbols));
        return result;
    }

    public static Map<Character, Character> getDecodeAlphabet(List<String> dict, List<String> text){

        Map<Character, Double> frequencySymbolsInText = Analyser.getFrequencySymbols(text);

        dict = dict.stream()
                .map(t ->  t
                        .toLowerCase()
                        .chars()
                        .mapToObj(i -> (char) i)
                        .filter(frequencySymbolsInText::containsKey)
                        .map(Object::toString)
                        .collect(joining()))
                .toList();

        frequencySymbolsInDict = Analyser.getFrequencySymbols(dict);
        Map<Character, Character> decodeAlphabet = frequencySymbolsInText.entrySet().stream()
                //.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                v -> getCharByFrequency(v.getValue())));

        correctAlphabet(decodeAlphabet, 'и','н');
        correctAlphabet(decodeAlphabet, 'у','п');
        correctAlphabet(decodeAlphabet, 'ы','ч');
        correctAlphabet(decodeAlphabet, 'з','г');
        correctAlphabet(decodeAlphabet, 'ё','ю');
        correctAlphabet(decodeAlphabet, 'ы','г');
        correctAlphabet(decodeAlphabet, 'ш','й');
        correctAlphabet(decodeAlphabet, 'ш','ё');
        correctAlphabet(decodeAlphabet, 'ж','ё');
        correctAlphabet(decodeAlphabet, 'э','ц');

        List<String> decryptedText = Cipher.replaceSymbols(text, decodeAlphabet);

        decryptedText.forEach(System.out::println);

        int countTrue = 0, countAll = 0;
        for (Map.Entry<Character, Character> entry : decodeAlphabet.entrySet()) {
            if (entry.getKey().equals(entry.getValue())){
                countTrue++;
            }
            countAll++;
        }
        System.out.println("Угадал: " + countTrue + " из " + countAll);

        throw new UnsupportedOperationException();
        //return null;
    }

    private static Character getCharByFrequency(double aFreq) {
        Character symbol = frequencySymbolsInDict.entrySet().stream()
                .min(Comparator.comparingDouble(e -> Math.abs(e.getValue() - aFreq)))
                .map(Map.Entry::getKey)
                .orElse('!');
        frequencySymbolsInDict.remove(symbol);
        return symbol;
    }

    private static void correctAlphabet(Map<Character, Character> alphabet, char c1, char c2){
        Character keySymbolFirst = getKeyByValue(alphabet, c1);
        Character keySymbolSecond = getKeyByValue(alphabet, c2);
        alphabet.replace(keySymbolFirst, c2);
        alphabet.replace(keySymbolSecond, c1);
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .findAny()
                .orElse(null);
    }
}
