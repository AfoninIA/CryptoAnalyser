package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.entity.ActionParameters;
import ru.javarush.cryptoanalyser.afonin.entity.Result;

import java.util.ArrayList;
import java.util.List;

public interface Action {
    Result execute(String[] parameters);
    //List<ActionParameters> getActionParameter();
}
