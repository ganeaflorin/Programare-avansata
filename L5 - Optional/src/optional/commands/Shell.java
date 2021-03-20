package optional.commands;

import optional.exceptions.InvalidCommandException;
import optional.items.Catalog;

import java.io.IOException;
import java.util.Scanner;

import static optional.commands.SaveCommand.save;

public class Shell {
    private Scanner scanner;
    Catalog catalog;

    public Shell(Catalog catalog) {
        scanner = new Scanner(System.in);
        this.catalog = catalog;
    }

    public void getCommands() throws IOException {
        System.out.println("Comenzi disponibile: \n 1. load \n 2. save\n 3. list\n " +
                "4. add book <nume> <path> <autor> <an lansare>\n " +
                "5. add song <nume> <path> <cantaret> <an lansare>\n " +
                "6. play <nume book/song>\n " +
                "7. quit");
        while (true) {
            System.out.print("Introduceti o comanda: ");
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] splitInput = input.split(" ");
            String command = splitInput[0];
            if (!command.equals("add") && !command.equals("save") && !command.equals("list") && !command.equals("play") && !command.equals("load"))
                throw new InvalidCommandException();
            switch (command) {
                case "add": {
                    AddCommand add = new AddCommand(this.catalog);
                    if (splitInput[1].equals("book"))
                        add.addBook(splitInput[2], splitInput[3], splitInput[4], Integer.parseInt(splitInput[5]));
                    if (splitInput[1].equals("song"))
                        add.addBook(splitInput[2], splitInput[3], splitInput[4], Integer.parseInt(splitInput[5]));
                }
                break;
                case "save":
                    ListCommand save = new ListCommand(this.catalog);
//                    catalog.setPath("C:\\Users\\andre\\OneDrive\\Desktop\\catalog2.txt");
                    save(catalog);
                    break;
                case "list":
                    ListCommand list = new ListCommand(this.catalog);
                    list.list();
                    break;
                case "play": {
                    PlayCommand play = new PlayCommand(this.catalog);
                    play.play(splitInput[1]);
                    break;
                }
                case "load": {
                    LoadCommand load = new LoadCommand(this.catalog);
                    this.catalog = load.load(splitInput[1]);
                    break;
                }
            }
        }
    }
}
