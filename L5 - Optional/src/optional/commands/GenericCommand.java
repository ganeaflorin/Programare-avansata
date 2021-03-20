package optional.commands;

import optional.items.Catalog;
import optional.items.Item;

public abstract class GenericCommand {
    static Catalog catalog;

    public GenericCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void addItem(Item item) {
        catalog.add(item);
    }
}
