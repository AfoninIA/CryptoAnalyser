package ru.javarush.cryptoanalyser.afonin.controller;

import ru.javarush.cryptoanalyser.afonin.commands.Action;
import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyser.afonin.exeption.ApplicationExeption;

public class MainController {

    public Result execute(String command, String[] parameters) {
        Action action = Actions.find(command);
        try {
            return action.execute(parameters);
        } catch (NumberFormatException | ApplicationExeption e){
            return new Result(ResultCode.ERROR, "Такая вот фигня, брат:\n" + e);
        }
    }

}
