package ru.javarush.cryptoanalyser.afonin.controller;

import ru.javarush.cryptoanalyser.afonin.commands.Action;
import ru.javarush.cryptoanalyser.afonin.entity.Result;

public class MainController {

    public Result execute(String command, String[] parameters) {
        Action action = Actions.find(command);
        return action.execute(parameters);
    }

}
