package app;

import com.*;

import java.util.*;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale locale = Locale.getDefault();
        LocaleManager.updateLocale();
        final String QUIT_COMMAND = "quit";

        while (true) {
            System.out.println(LocaleManager.getPrompt());
            String input = scanner.nextLine();
            if (input.equals(QUIT_COMMAND)) {
                break;
            }
            Command localeCommand = CommandHandler.handleCommands(input);
            System.out.println(localeCommand.execute());
        }
    }
}

