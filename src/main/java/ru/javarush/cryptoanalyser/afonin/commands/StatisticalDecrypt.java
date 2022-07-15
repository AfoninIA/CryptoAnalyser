package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyser.afonin.util.Analyser;
import ru.javarush.cryptoanalyser.afonin.util.PathFinder;

import java.util.List;
import java.util.Map;

public class StatisticalDecrypt implements Action{
    @Override
    public Result execute(String[] parameters) {
        //statisticaldecript dict.txt encoded.txt 9
        parameters = new String[]{"dictfull.txt", "idiot.txt", "9"};
        String dictTxtFile = parameters[0];
        String encodedTxtFile = parameters[1];

        List<String> dict = PathFinder.readText(dictTxtFile);
        List<String> text = PathFinder.readText(encodedTxtFile);
        Analyser.getDecodeAlphabet(dict, text);


        return new Result(ResultCode.OK, "all text anylysed");
    }
}
