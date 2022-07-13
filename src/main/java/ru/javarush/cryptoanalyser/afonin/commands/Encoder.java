package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.constans.BaseAlphabet;
import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyser.afonin.util.Cipher;


public class Encoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        //encode text.txt encoded.txt 9
        String inputTxtFile = parameters[0];
        String outputEncryptedTxtFile = parameters[1];
        int keyShift = Integer.parseInt(parameters[2]);
        Cipher.cesarCipher(inputTxtFile, outputEncryptedTxtFile, keyShift);
        return new Result(ResultCode.OK, "all text encoded");
    }
}
