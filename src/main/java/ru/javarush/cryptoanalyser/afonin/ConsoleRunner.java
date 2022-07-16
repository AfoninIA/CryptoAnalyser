package ru.javarush.cryptoanalyser.afonin;

import ru.javarush.cryptoanalyser.afonin.controller.MainController;
import ru.javarush.cryptoanalyser.afonin.view.ConsoleApp;
import ru.javarush.cryptoanalyser.afonin.view.Menu;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu(input);
        MainController mainController = new MainController();
        ConsoleApp application = new ConsoleApp(mainController, menu);
        application.run(args);
    }
}
