package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class Invalid implements Command {
    @Override
    public String execute() {
        Locale locale = Locale.getDefault();
        ResourceBundle messages = ResourceBundle.getBundle(baseName, locale);
        return messages.getString("invalid");
    }
}