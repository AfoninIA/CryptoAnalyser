package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.entity.ResultCode;

public class Exit extends Action {
    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, "Спасибо что зашли!");
    }
}
