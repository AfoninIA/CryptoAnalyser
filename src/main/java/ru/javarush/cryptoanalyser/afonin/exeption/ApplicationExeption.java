package ru.javarush.cryptoanalyser.afonin.exeption;

import jdk.jshell.spi.ExecutionControl;

public class ApplicationExeption extends RuntimeException {
    public ApplicationExeption() {
        super();
    }

    public ApplicationExeption(String message) {
        super(message);
    }

    public ApplicationExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationExeption(Throwable cause) {
        super(cause);
    }
}
