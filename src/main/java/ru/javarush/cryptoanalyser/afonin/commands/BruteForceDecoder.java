package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.entity.ActionParameters;
import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyser.afonin.util.Cipher;

import java.util.ArrayList;
import java.util.List;

public class BruteForceDecoder implements Action{

    @Override
    public Result execute(String[] parameters) {
        //bruteforce-decode encoded.txt bruteforce-decoded.txt
        String inputEncodedTxtFile = parameters[0];
        String outputDecryptedTxtFile = parameters[1];

        Cipher.bruteForceDecode(inputEncodedTxtFile, outputDecryptedTxtFile);
        return new Result(ResultCode.OK, "Text decoded");
    }

}
