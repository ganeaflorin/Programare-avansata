package app;

import com.Command;
import com.DisplayLocale;
import com.Invalid;
import com.Info;
import com.SetLocale;

import java.util.Arrays;
import java.util.List;

public class CommandHandler {
    private static final String LOCALE_COMMAND = "locales";
    private static final String SET_COMMAND = "locale.set";
    private static final String INFO_COMMAND = "info";

    public static Command handleCommands(String input) {
        if (input.equals(LOCALE_COMMAND)) {
            return new DisplayLocale();
        }
        if (input.contains(SET_COMMAND)) {
            List<String> inputSplit = Arrays.asList(input.split(" "));
            return new SetLocale(inputSplit.get(1));
        }
        if (input.equals(INFO_COMMAND)) {
            return new Info();
        }
        return new Invalid();
    }
}
