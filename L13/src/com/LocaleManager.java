package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleManager {
    private static ResourceBundle messages;

    public static void updateLocale() {
        String baseName = "res/Messages";
        Locale locale = Locale.getDefault();
        messages = ResourceBundle.getBundle(baseName, locale);
    }

    public static String getPrompt() {
        return messages.getString("prompt");
    }

    public static String getInfo() {
        return messages.getString("info");
    }

    public static String getCountry() {
        return messages.getString("country");
    }

    public static String getLanguage() {
        return messages.getString("language");
    }

    public static String getWeekdays() {
        return messages.getString("weekdays");
    }

    public static String getCurrency() {
        return messages.getString("currency");
    }

    public static String getMonths() {
        return messages.getString("months");
    }

    public static String getToday() {
        return messages.getString("today");
    }

    public static String getLocalSet() {
        return messages.getString("locale.set");
    }

}