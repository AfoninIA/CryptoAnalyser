package ru.javarush.cryptoanalyser.afonin.view;

import ru.javarush.cryptoanalyser.afonin.controller.MainController;
import ru.javarush.cryptoanalyser.afonin.entity.Result;

import java.util.Arrays;


public class ConsoleApp {

    private final MainController mainController;

    private final Menu menu;

    public ConsoleApp(MainController mainController, Menu menu) {
        this.mainController = mainController;
        this.menu = menu;
    }

    public void run(String[] args) {
        String[] argsConsole = menu.run();
        String command = argsConsole[0]; //encode
        String[] parametrs = Arrays.copyOfRange(argsConsole, 1, argsConsole.length);
        mainController.execute(command, parametrs);
        //Result result;
    }
}
