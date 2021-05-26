package com;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale implements Command {
    static List<String> locales = Arrays.asList("en-US", "ro-RO");
    String lang;
    String country;

    public static List<String> getLocales() {
        return locales;
    }

    public SetLocale(String tag) {
        if (locales.contains(tag)) {
            List<String> tagSplit = Arrays.asList(tag.split("-"));
            lang = tagSplit.get(0);
            country = tagSplit.get(1);
        } else {
            lang = "en";
            country = "US";
        }
    }

    @Override
    public String execute() {
        Locale.setDefault(new Locale(lang, country));
        LocaleManager.updateLocale();
        Locale locale = Locale.getDefault();
        ResourceBundle messages = ResourceBundle.getBundle(baseName, locale);
        Object[] args = {locale};

        return new MessageFormat(LocaleManager.getLocalSet()).format(args);
    }
}