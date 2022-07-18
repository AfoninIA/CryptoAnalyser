package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyser.afonin.util.Cipher;
import ru.javarush.cryptoanalyser.afonin.util.MyFileUtils;


public class Decoder extends Action {

    @Override
    public String[] getRegexpValidateParameters() {
        return new String[]{
                MyFileUtils.getPathRegex(),
                MyFileUtils.getPathRegex(),
                "\\d+"};
    }

    @Override
    public Result execute(String[] parameters) {
        //decode encoded.txt decrypted.txt 9
        if (!checkParameters(parameters)) {
            return new Result(ResultCode.ERROR, "Некорректные параметры, повторите ввод.");
        }
        String inputTxtFile = parameters[0];
        String outputDecryptedTxtFile = parameters[1];
        int keyShift = Integer.parseInt(parameters[2]);
        Cipher.cesarCipher(inputTxtFile, outputDecryptedTxtFile, -keyShift);
        return new Result(ResultCode.OK, "Текст декодирован");
    }

}
