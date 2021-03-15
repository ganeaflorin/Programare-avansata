package compulsory.items;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<Item> catalogItems;
    private String path;

    public Catalog(String path) {
        this.catalogItems = new ArrayList<>();
        this.path = path;
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

    public void list() {
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

    public static Catalog load(Catalog catalog) {
        String path = "C:\\\\Users\\\\andre\\\\OneDrive\\\\Desktop\\\\catalog.txt";
        try {

            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Catalog obj = (Catalog) objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }
    }
}

