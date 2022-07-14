package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyser.afonin.exeption.ApplicationExeption;
import ru.javarush.cryptoanalyser.afonin.util.Analyser;
import ru.javarush.cryptoanalyser.afonin.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

public class StatisticalDecrypt implements Action{
    @Override
    public Result execute(String[] parameters) {
        //statisticaldecript dict.txt encoded.txt 9
        String dictTxtFile = parameters[0];

        List<String> dict;
        try {
            dict = Files.readAllLines(PathFinder.getPathFile(dictTxtFile));
            dict.forEach(System.out::println);
            Map<Character, Integer> frequencySymbols = Analyser.getFrequencySymbols(dict);
            frequencySymbols.entrySet().forEach(System.out::println);
        } catch (IOException e) {
            throw new ApplicationExeption();
        }

        return new Result(ResultCode.OK, "all text anylysed");
    }
}
