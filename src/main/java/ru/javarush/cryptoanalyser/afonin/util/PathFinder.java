package ru.javarush.cryptoanalyser.afonin.util;

import java.io.File;
import java.nio.file.Path;

public class PathFinder {
    public static String getRoot(){
        String root = System.getProperty("user.dir");
        return root + File.separator + "text" + File.separator;
    }

    public static Path getPathFile(String fileAddress){
        return Path.of(PathFinder.getRoot() + fileAddress);
    }
}
