package optional.commands;

import optional.exceptions.ItemNameNotFoundException;
import optional.items.Catalog;
import optional.items.Item;

import java.awt.*;
import java.io.File;
import java.util.List;

public class PlayCommand extends GenericCommand {
    public PlayCommand(Catalog catalog) {
        super(catalog);
    }

    public void play(String name) {

        try {
            List<Item> catalogItems = catalog.getCatalogItems();
            Item item = null;
            for (Item itemIterator : catalogItems)
                if (itemIterator.getName() != null)
                    if (itemIterator.getName().equals(name))
                        item = itemIterator;
//            if (item == null) throw new ItemNameNotFoundException();
            File file = new File(String.valueOf(catalogItems.get(catalogItems.indexOf(item)).getPath()));
            if (!Desktop.isDesktopSupported()) {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())
                desktop.open(file);
        } catch (NullPointerException e) {
            System.out.println("Please load a catalog first.");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Enter a valid item name.");
        }
    }
}
