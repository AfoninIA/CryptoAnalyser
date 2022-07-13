package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.constans.BaseAlphabet;
import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyser.afonin.util.Cipher;


public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        //decode encoded.txt decrypted.txt 9
        String inputTxtFile = parameters[0];
        String outputDecryptedTxtFile = parameters[1];
        int keyShift = Integer.parseInt(parameters[2]);
        Cipher.cesarCipher(inputTxtFile, outputDecryptedTxtFile, -keyShift);
        return new Result(ResultCode.OK, "all text decoded");
    }
}
