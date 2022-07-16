package ru.javarush.cryptoanalyser.afonin.view;

import ru.javarush.cryptoanalyser.afonin.controller.Actions;

import java.util.LinkedHashMap;
import java.util.Map;

public interface Messages {
    Map<String, String[][]> QUESTION = new LinkedHashMap<>();

    String[][][] QESTIONS = new String[][][]{
            {
                    {"Шифровать"},
                    {Actions.ENCODE.name()},
                    {"Где взять файл (полный адрес ИЛИ только имя ИЛИ нажмите Enter чтобы использовать ", "text.txt", "шаблон"},
                    {"Куда положить (полный адрес ИЛИ только имя ИЛИ нажмите Enter чтобы использовать ", "encoded.txt", "шаблон"},
                    {"Какой ключ использовать (целое число ИЛИ нажмите Enter чтобы использовать ", "7", "шаблон"}
            },
            {
                    {"Дешифровать с ключём"},
                    {Actions.DECODE.name()},
                    {"Где взять файл (полный адрес ИЛИ только имя ИЛИ нажмите Enter чтобы использовать ", "encoded.txt", "шаблон"},
                    {"Куда положить (полный адрес ИЛИ только имя ИЛИ нажмите Enter чтобы использовать ", "decoded.txt", "шаблон"},
                    {"Какой ключ использовать (целое число ИЛИ нажмите Enter чтобы использовать ", "7", "шаблон"}
            },
            {
                    {"Дешифровать брутфорсом"},
                    {Actions.BRUTEFORCE_DECODE.name()},
                    {"Где взять файл (полный адрес ИЛИ только имя ИЛИ нажмите Enter чтобы использовать ", "encoded.txt", "шаблон"},
                    {"Куда положить (полный адрес ИЛИ только имя ИЛИ нажмите Enter чтобы использовать ", "brutforce.txt", "шаблон"}
            },
            {
                    {"Дешифровать анализом"},
                    {Actions.STATISTICAL_DECRYPT.name()},
                    {"Где взять файл (полный адрес ИЛИ только имя ИЛИ нажмите Enter чтобы использовать ", "encoded.txt", "шаблон"},
                    {"Куда положить (полный адрес ИЛИ только имя ИЛИ нажмите Enter чтобы использовать ", "analysed.txt", "шаблон"},
                    {"Где взять словарь (полный адрес ИЛИ только имя ИЛИ нажмите Enter чтобы использовать ", "dict.txt", "шаблон"}
            }
    };

}
