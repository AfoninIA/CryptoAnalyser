package ru.javarush.cryptoanalyser.afonin.controller;

import ru.javarush.cryptoanalyser.afonin.commands.Action;
import ru.javarush.cryptoanalyser.afonin.commands.Decoder;
import ru.javarush.cryptoanalyser.afonin.commands.Encoder;

import java.util.Locale;

public enum Actions {

    ENCODE(new Encoder()),
    DECODE(new Decoder());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
