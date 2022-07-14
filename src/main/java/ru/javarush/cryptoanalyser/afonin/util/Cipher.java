package ru.javarush.cryptoanalyser.afonin.util;

import ru.javarush.cryptoanalyser.afonin.constans.BaseAlphabet;
import ru.javarush.cryptoanalyser.afonin.exeption.ApplicationExeption;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static java.util.stream.Collectors.joining;

public class Cipher {

    private static List<String> readText(Path path){
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new ApplicationExeption("IO error", e);
        }
    }

    private static void saveToFile(Path outputFile, List<String> text){
        try {
            Files.write(outputFile, text, Charset.defaultCharset());
        } catch (IOException e) {
            throw new ApplicationExeption("IO error", e);
        }
    }

    private static Map<Character, Character> getCryptoAlphabet(int keyShift) {
        Map<Character, Character> cryptoAlphabet = new HashMap<>();
        char[] alphabet = BaseAlphabet.ALPHABET;
        for (int i = 0; i < alphabet.length; i++) {
            cryptoAlphabet.put(alphabet[i], alphabet[(alphabet.length + i + keyShift) % alphabet.length]);
        }
        return cryptoAlphabet;
    }

    public static void cesarCipher(String nameInputTxtFile, String nameOutputTxtFile, int keyShift){

        List<String> inputText = readText(PathFinder.getPathFile(nameInputTxtFile));
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

        saveToFile(PathFinder.getPathFile(nameOutputTxtFile), shiftedText);
    }
}
