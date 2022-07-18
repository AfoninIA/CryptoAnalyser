package ru.javarush.cryptoanalyser.afonin.commands;

import ru.javarush.cryptoanalyser.afonin.entity.Result;


public abstract class Action {

    public abstract Result execute(String[] parameters);

    public String[] getRegexpValidateParameters(){
        return new String[0];
    }

    public Boolean checkParameters(String[] parameters) {
        String[] regexpValidateParameters = getRegexpValidateParameters();
        if (parameters.length != regexpValidateParameters.length) {
            return false;
        }
        for (int i = 0; i < parameters.length; i++) {
            if (!parameters[i].matches(regexpValidateParameters[i])) {
                return false;
            }
        }
        return true;
    }
}
