package ru.javarush.cryptoanalyser.afonin.util;

import ru.javarush.cryptoanalyser.afonin.constans.BaseAlphabet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static java.util.stream.Collectors.joining;


public class Cipher {





    private static Map<Character, Character> getCryptoAlphabet(int keyShift) {
        Map<Character, Character> cryptoAlphabet = new HashMap<>();
        char[] alphabet = BaseAlphabet.ALPHABET;
        for (int i = 0; i < alphabet.length; i++) {
            cryptoAlphabet.put(alphabet[i], alphabet[(alphabet.length + i + keyShift) % alphabet.length]);
        }
        return cryptoAlphabet;
    }

    public static void cesarCipher(String nameInputTxtFile, String nameOutputTxtFile, int keyShift){

        List<String> inputText = PathFinder.readText(nameInputTxtFile);
        Map<Character, Character> cryptoAlphabet = getCryptoAlphabet(keyShift);

        List<String> shiftedText = inputText.stream()
                .map(t ->  t
                        .toLowerCase()
                        .chars()
                        .mapToObj(i -> (char) i)
                        .filter(cryptoAlphabet::containsKey)
                        .map(cryptoAlphabet::get)
                        .map(Object::toString)
                        .collect(joining()))
                .toList();

        PathFinder.saveToFile(nameOutputTxtFile, shiftedText);
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
