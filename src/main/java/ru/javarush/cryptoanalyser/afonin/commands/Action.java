package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
