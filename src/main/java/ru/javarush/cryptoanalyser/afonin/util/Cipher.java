package ru.javarush.cryptoanalyser.afonin.util;

import ru.javarush.cryptoanalyser.afonin.constans.BaseAlphabet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static java.util.stream.Collectors.joining;


public class Cipher {

    private static Map<Character, Character> getShiftCryptoAlphabet(int keyShift) {
        Map<Character, Character> cryptoAlphabet = new HashMap<>();
        char[] alphabet = BaseAlphabet.ALPHABET;
        keyShift = alphabet.length + (keyShift % alphabet.length);
        for (int i = 0; i < alphabet.length; i++) {
            cryptoAlphabet.put(alphabet[i], alphabet[(i + keyShift) % alphabet.length]);
        }
        return cryptoAlphabet;
    }

    public static void cesarCipher(String nameInputTxtFile, String nameOutputTxtFile, int keyShift){
        List<String> inputText = PathFinder.readText(nameInputTxtFile);
        Map<Character, Character> cryptoAlphabet = getShiftCryptoAlphabet(keyShift);
        List<String> shiftedText = replaceSymbols(inputText, cryptoAlphabet);
        PathFinder.saveToFile(nameOutputTxtFile, shiftedText);
    }

    public static void staticticalDecrypt(String nameInputTxtFile, String nameOutputTxtFile, String dictionaryFileName) {
        List<String> inputText = PathFinder.readText(nameInputTxtFile);
        List<String> dict = PathFinder.readText(dictionaryFileName);
        Map<Character, Character> decodeAlphabet = Analyser.getDecodeAlphabet(dict, inputText);
        decodeAlphabet.entrySet().forEach(System.out::println);

        int countTrue = 0, countAll = 0;
        for (Map.Entry<Character, Character> entry : decodeAlphabet.entrySet()) {
            if (entry.getKey().equals(entry.getValue())){
                countTrue++;
            }
            countAll++;
        }
        System.out.println("Угадал: " + countTrue + " из " + countAll);

        List<String> decryptedText = Cipher.replaceSymbols(inputText, decodeAlphabet);
        PathFinder.saveToFile(nameOutputTxtFile, decryptedText);
    }

    public static void bruteForceDecode(String nameInputTxtFile, String nameOutputTxtFile){
        List<String> inputText = PathFinder.readText(nameInputTxtFile);
        List<String> decryptedText = new ArrayList<>();
        int keyShift = 0;
        for (; keyShift < BaseAlphabet.ALPHABET.length; keyShift++) {
            Map<Character, Character> cryptoAlphabet = getShiftCryptoAlphabet(keyShift);
            decryptedText = replaceSymbols(inputText, cryptoAlphabet);
            if (Analyser.isText(decryptedText)){
                break;
            }
        }
        PathFinder.saveToFile(nameOutputTxtFile, decryptedText);
    }

    public static List<String> replaceSymbols(List<String> text, Map<Character, Character> alphabet){
        return text.stream()
                .map(t ->  t
                        .toLowerCase()
                        .chars()
                        .mapToObj(i -> (char) i)
                        .filter(alphabet::containsKey)
                        .map(alphabet::get)
                        .map(Object::toString)
                        .collect(joining()))
                .toList();
    }
}
