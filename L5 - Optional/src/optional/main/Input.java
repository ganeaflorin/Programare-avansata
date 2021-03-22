package optional.main;

import optional.commands.Shell;
import optional.items.Catalog;

import java.io.IOException;

public class Input {
    private static Shell shell;
    Catalog catalog;

    public Input() {
        catalog = null;
        shell = new Shell();
    }

    public static void startShell() throws IOException {
        shell.getCommands();
    }
}
