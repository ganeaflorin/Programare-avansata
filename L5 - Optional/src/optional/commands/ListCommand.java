package optional.commands;

import optional.items.Catalog;
import optional.items.Item;

public class ListCommand extends GenericCommand {

    public ListCommand(Catalog catalog) {
        super(catalog);
    }

    public void list() {
        System.out.println("Nume catalog: " + catalog.getCatalogName());
        for (Item item : catalog.getCatalogItems()) {
            System.out.println(item.toString());
        }
    }
}
