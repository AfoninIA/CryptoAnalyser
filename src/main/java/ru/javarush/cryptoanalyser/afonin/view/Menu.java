package ru.javarush.cryptoanalyser.afonin.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner input;
    private final List<MenuEntry> entries = new ArrayList<>();

    public Menu(Scanner input) {
        this.input = input;
        addEntrys();
    }

    public String[] run(){

        while (true){
            printMenu();
            String line = input.nextLine();
            int choice = Integer.parseInt(line);
            if (choice == 0) break;
            if (choice > entries.size()+1) continue;

            MenuEntry entry = entries.get(choice - 1);
            return entry.run(input);
        }
        return new String[0];
    }

    private void addEntrys(){
        for (String[][] comand : Messages.QESTIONS) {
            entries.add(new MenuEntry(comand[0][0], Arrays.copyOfRange(comand, 1, comand.length)));
        }

    }

    private void printMenu() {
        System.out.println("Что нужно сделать?");
        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i+1) + " : " + entries.get(i).toString());
        }
        System.out.println("0 : Выйти");
    }
}
