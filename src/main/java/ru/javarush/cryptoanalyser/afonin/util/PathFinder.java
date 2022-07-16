package ru.javarush.cryptoanalyser.afonin.util;

import ru.javarush.cryptoanalyser.afonin.exeption.ApplicationExeption;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PathFinder {
    public static String getRoot(){
        String root = System.getProperty("user.dir");
        return root + File.separator + "text" + File.separator;
    }

    public static Path getPathFile(String fileAddress){
        return Path.of(PathFinder.getRoot() + fileAddress);
    }

    public static List<String> readText(Path path){
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new ApplicationExeption("IO error", e);
        }
    }

    public static List<String> readText(String fileName){
        return readText(getPathFile(fileName));
    }

    public static void saveToFile(Path outputFile, List<String> text){
        try {
            Files.write(outputFile, text, Charset.defaultCharset());
        } catch (IOException e) {
            throw new ApplicationExeption("IO error", e);
        }
    }

    public static void saveToFile(String fileName, List<String> text){
        saveToFile(getPathFile(fileName), text);
    }


}
