package ru.javarush.cryptoanalyser.afonin.util;

import java.util.*;
import java.util.stream.Collectors;


public class Analyser {
    private static final double MIN_SPACE_IN_1000_SYMBOLS = 130 / 1000d;

    public static boolean isText(List<String> analysedText){
        return getFrequencySymbols(analysedText).getOrDefault(' ', 0d) > MIN_SPACE_IN_1000_SYMBOLS;
    }

    public static Map<Character, Double> getFrequencySymbols(List<String> text){
        Map<Character, Double> result = new HashMap<>();
        text.stream()
                .map(String::toLowerCase)
                .flatMapToInt(String::chars)
                .mapToObj(i -> (char)i)
                .forEach(key -> result.put(key, result.getOrDefault(key, 0d) + 1));

        double sumAllSymbols = result.values().stream().mapToDouble(i -> i).sum();
        result.replaceAll((key, value) -> (value * 1000 / sumAllSymbols));
        System.out.println("Частотность: ");
        result.entrySet().forEach(System.out::println);
        return result;
    }

    public static Map<Character, Character> getDecodeAlphabet(List<String> dict, List<String> text){

        Map<Character, Double> frequencySymbolsInText = Analyser.getFrequencySymbols(text);
        Map<Character, Double> frequencySymbolsInDict = Analyser.getFrequencySymbols(dict);
        Map<Character, Character> alphabet = frequencySymbolsInText.entrySet().stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                v -> getCharByFrequency(v.getValue(), frequencySymbolsInDict)));
        System.out.println("Алфавит");
        alphabet.entrySet().forEach(System.out::println);
        return alphabet;

    }

    private static Character getCharByFrequency(double frequency, Map<Character, Double> srcFrequencySymbols) {
        Character symbol = srcFrequencySymbols.entrySet().stream()
                .min(Comparator.comparingDouble(e -> Math.abs(e.getValue() - frequency)))
                .map(Map.Entry::getKey)
                .orElse('!');
        srcFrequencySymbols.remove(symbol);
        return symbol;
    }

    private static void correctAlphabet(Map<Character, Character> alphabet, char c1, char c2){
        Character keySymbolFirst = getKeyByValue(alphabet, c1);
        Character keySymbolSecond = getKeyByValue(alphabet, c2);
        alphabet.replace(keySymbolFirst, c2);
        alphabet.replace(keySymbolSecond, c1);
    }

    private static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .findAny()
                .orElse(null);
    }
}
