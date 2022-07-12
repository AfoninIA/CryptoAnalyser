package ru.javarush.cryptoanalyser.afonin;

import ru.javarush.cryptoanalyser.afonin.controller.MainController;
import ru.javarush.cryptoanalyser.afonin.entity.Result;
import ru.javarush.cryptoanalyser.afonin.toplevel.Application;


public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        //encode text.txt encoded.txt 9
        Application application = new Application(mainController);
        Result result = application.run(args);
        System.out.println(result);
    }
}
