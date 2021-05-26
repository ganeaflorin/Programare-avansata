package com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info implements Command {
    @Override
    public String execute() {
        Locale locale = Locale.getDefault();
        String currentTag = new MessageFormat(LocaleManager.getInfo()).format(new Object[]{locale});
        return currentTag + "\n" + LocaleManager.getCountry() + locale.getDisplayCountry() + '\n' +
                LocaleManager.getLanguage() + locale.getDisplayLanguage() + '\n' +
                LocaleManager.getCurrency() + Currency.getInstance(locale).getCurrencyCode() + '(' + Currency.getInstance(locale).getSymbol() + ')' + '\n' +
                getWeekdays(locale) + '\n' +
                getMonths(locale) + '\n' +
                LocaleManager.getToday() + getTodaysData(locale) + '\n';
    }

    public String getWeekdays(Locale locale) {
        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        String[] days = dfs.getWeekdays();
        StringBuilder returnValue = new StringBuilder(LocaleManager.getWeekdays());
        for (String day : days)
            returnValue.append(day).append(' ');
        return returnValue.toString();
    }

    public String getMonths(Locale locale) {
        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        String[] months = dfs.getMonths();
        StringBuilder returnValue = new StringBuilder(LocaleManager.getMonths());
        for (String month : months) {
            returnValue.append(month).append(' ');
        }
        return returnValue.toString();
    }

    public String getTodaysData(Locale locale) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        Date today = new Date();
        return df.format(today);
    }

}
