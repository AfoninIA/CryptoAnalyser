package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyser.afonin.util.ScramblerUtil;
import ru.javarush.cryptoanalyser.afonin.util.MyFileUtils;


public class StatisticalDecrypt extends Action {

    @Override
    public String[] getRegexpValidateParameters() {
        return new String[]{
                MyFileUtils.getPathRegex(),
                MyFileUtils.getPathRegex()
        };
    }

    @Override
    public Result execute(String[] parameters) {
        //statistical-decrypt encoded.txt decodedAnalyse.txt dict.txt
        if (!checkParameters(parameters)) {
            return new Result(ResultCode.ERROR, "Некорректные параметры, повторите ввод.");
        }
        String encodedTxtFile = parameters[0];
        String outputDecodedTxtFile = parameters[1];
        String dictTxtFile = parameters[2];
        ScramblerUtil.staticticalDecrypt(encodedTxtFile, outputDecodedTxtFile, dictTxtFile);
        return new Result(ResultCode.OK, "Текст декодирован");
    }
}
