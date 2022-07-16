package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyser.afonin.util.Cipher;


public class StatisticalDecrypt implements Action{
    @Override
    public Result execute(String[] parameters) {
        //statistical-decrypt encoded.txt decodedAnalyse.txt dict.txt
        //parameters = new String[]{"dictfull.txt", "idiot.txt", "decodedAnalyse.txt"};
        String encodedTxtFile = parameters[0];
        String outputDecodedTxtFile = parameters[1];
        String dictTxtFile = parameters[2];
        Cipher.staticticalDecrypt(encodedTxtFile, outputDecodedTxtFile, dictTxtFile);
        return new Result(ResultCode.OK, "all text analysed");
    }
}
