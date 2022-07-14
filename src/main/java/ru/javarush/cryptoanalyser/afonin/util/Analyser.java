package ru.javarush.cryptoanalyser.afonin.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Analyser {
    private static final int SPACE_IN_1000_SYMBOLS = 174;

    public static boolean isText(List<String> analysedText){
        throw new UnsupportedOperationException();
    }

    public static Map<Character, Integer> getFrequencySymbols(List<String> text){
        Map<Character, Integer> frequencySymbols = new HashMap<>();
        text.stream()
                .map(String::toLowerCase)
                .flatMapToInt(String::chars)
                .mapToObj(i -> (char)i)
                .forEach(key -> frequencySymbols.put(key, frequencySymbols.getOrDefault(key, 0) + 1));
        return frequencySymbols;
    }
}
