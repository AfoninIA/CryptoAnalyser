package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyser.afonin.util.Cipher;
import ru.javarush.cryptoanalyser.afonin.util.MyFileUtils;

public class BruteForceDecoder extends Action {

    @Override
    public String[] getRegexpValidateParameters() {
        return new String[]{
                MyFileUtils.getPathRegex(),
                MyFileUtils.getPathRegex()
        };
    }

    @Override
    public Result execute(String[] parameters) {
        //bruteforce-decode encoded.txt bruteforce-decoded.txt
        if (!checkParameters(parameters)) {
            return new Result(ResultCode.ERROR, "Некорректные параметры, повторите ввод.");
        }
        String inputEncodedTxtFile = parameters[0];
        String outputDecryptedTxtFile = parameters[1];

        Cipher.bruteForceDecode(inputEncodedTxtFile, outputDecryptedTxtFile);
        return new Result(ResultCode.OK, "Текст декодирован");
    }

}
