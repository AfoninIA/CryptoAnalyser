package ru.javarush.cryptoanalyser.afonin.util;

import ru.javarush.cryptoanalyser.afonin.exeption.ApplicationExeption;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MyFileUtils {
    public static final String rootSystem = String.valueOf(Path.of("").toAbsolutePath().getRoot());

    public static String getPathRegex() {

        return ("^(" + rootSystem + ")?"
                + "[" + File.separator + "а-яА-Яa-zA-Z0-9_.-]*"
                + "[а-яА-яa-zA-Z0-9_.-]+.txt$"
        ).replaceAll("\\\\", "\\\\\\\\");
    }

    public static boolean isAbsolutePath(String path) {
        return path.matches(("^(" + rootSystem + ").*").replaceAll("\\\\", "\\\\\\\\"));
    }

    public static String getRoot(){

        String root = System.getProperty("user.dir");
        return root + File.separator + "text" + File.separator;
    }

    public static Path getPathFile(String fileAddress){
        if (isAbsolutePath(fileAddress)){
            return Path.of(fileAddress);
        }
        return Path.of(MyFileUtils.getRoot() + fileAddress);
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
