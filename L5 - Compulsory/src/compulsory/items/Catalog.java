package compulsory.items;

import compulsory.exceptions.InvalidPathException;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<Item> catalogItems;
    private String path;
    private String catalogName;

    public Catalog(String catalogName) {
        this.catalogItems = new ArrayList<>();
        this.catalogName = catalogName;

    }

    public String getPath() {
        return path;
    }

    public void add(Item item) {
        catalogItems.add(item);
    }

    public void play(Item item) {
        try {
            File file = new File(String.valueOf(catalogItems.get(catalogItems.indexOf(item)).getPath()));
            if (!Desktop.isDesktopSupported()) {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())
                desktop.open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void list() {
        System.out.println("Nume catalog: " + this.catalogName);
        for (Item item : catalogItems) {
            System.out.println(item.toString());
        }
    }

    public static void save(Catalog catalog)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public Catalog load() throws InvalidPathException {
        try {

            FileInputStream fileIn = new FileInputStream(this.path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Catalog obj = (Catalog) objectIn.readObject();
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }

    }
}

