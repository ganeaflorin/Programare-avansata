package optional.commands;

import optional.exceptions.InvalidCommandException;
import optional.items.Catalog;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;

import static optional.commands.SaveCommand.save;

public class Shell {
    private Scanner scanner;
    Catalog catalog;

    public Shell() {
        scanner = new Scanner(System.in);
        this.catalog = new Catalog("Catalog 1", "C:\\Users\\andre\\OneDrive\\Desktop\\catalog-optional.txt");
    }

    public void getCommands() throws IOException {
        printCommands();
        while (true) {
            System.out.print("Introduceti o comanda: ");
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] splitInput = input.split(" ");
            String command = splitInput[0];
            if (!command.equals("add") && !command.equals("save") && !command.equals("list") && !command.equals("play") && !command.equals("load")) {
                System.out.printf("Please enter a valid command.\n");
                continue;
            }
            switch (command) {
                case "add":
                    addCase(splitInput);
                    break;
                case "save":
                    saveCase(splitInput);
                    break;
                case "list":
                    listCase();
                    break;
                case "play":
                    playCase(splitInput);
                    break;
                case "load":
                    loadCase(splitInput);
                    break;
            }
        }
    }

    private void printCommands() {
        System.out.println("Commands:\n" +
                "1. load <path>\n" +
                "2. save\n" +
                "3. list\n" +
                "4. add book <name> <path> <author> <release year>\n" +
                "5. add song <name> <path> <singer> <release year>\n" +
                "6. play <name book/song>\n" +
                "7. quit");
    }

    private void addCase(String[] splitInput) {
        AddCommand add = new AddCommand(this.catalog);

        try {
            if (splitInput.length == 7) {
                splitInput[4] += " " + splitInput[5];
                splitInput[5] = splitInput[6];
                splitInput[6] = null;
            }
            if (splitInput[1].equals("book"))
                add.addBook(splitInput[2], splitInput[3], splitInput[4], Integer.parseInt(splitInput[5]));
            if (splitInput[1].equals("song"))
                add.addBook(splitInput[2], splitInput[3], splitInput[4], Integer.parseInt(splitInput[5]));
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println("Not enough arguments.");
        } catch (NumberFormatException exp) {
            System.out.println("Please enter a valid year.");
        } catch (NullPointerException exp) {
            System.out.println("Load the catalog first.");
        }

    }

    private void saveCase(String[] splitInput) throws IOException {
        ListCommand save = new ListCommand(this.catalog);
        save(catalog);
    }

    private void listCase() {
        ListCommand list = new ListCommand(this.catalog);
        list.list();
    }

    private void playCase(String[] splitInput) {
        PlayCommand play = new PlayCommand(this.catalog);
        try {
            play.play(splitInput[1]);
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println("Not enough arguments");
        }
    }

    private void loadCase(String[] splitInput) {
        LoadCommand load = new LoadCommand(this.catalog);
        try {
            this.catalog = load.load(splitInput[1]);
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println("Not enough arguments.");
        }
    }
}
