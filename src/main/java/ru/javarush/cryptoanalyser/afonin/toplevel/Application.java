package ru.javarush.cryptoanalyser.afonin.toplevel;

import ru.javarush.cryptoanalyser.afonin.controller.MainController;
import ru.javarush.cryptoanalyser.afonin.entity.Result;
import java.util.Arrays;

public class Application {

    private final MainController mainController;

    public Application(MainController mainController){
        this.mainController = mainController;
    }

    public Result run(String[] args){
        String command = args[0]; //encode
        String[] parametrs = Arrays.copyOfRange(args, 1, args.length);
        return mainController.execute(command, parametrs);
    }
}
