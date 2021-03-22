package optional.commands;

import optional.items.Catalog;
import optional.items.Item;

import static java.lang.Thread.sleep;

public class ListCommand extends GenericCommand {

    public ListCommand(Catalog catalog) {
        super(catalog);
    }

    public void list() {
        try {
            System.out.println("Nume catalog: " + catalog.getCatalogName());

            for (Item item : catalog.getCatalogItems()) {
                System.out.println(item.toString());
            }
        } catch (Exception exp) {
            System.out.println("Please load a catalog first.");
        }

    }
}
