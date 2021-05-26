package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocale implements Command {
    @Override
    public String execute() {
        Locale locale = Locale.getDefault();
        ResourceBundle messages = ResourceBundle.getBundle("res/Messages", locale);
        String localeString = messages.getString("locales");
        StringBuilder returnValue = new StringBuilder();
        returnValue.append(localeString).append(" ").append(SetLocale.getLocales().toString());
        return returnValue.toString();
    }
}