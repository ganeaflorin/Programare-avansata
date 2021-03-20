package optional.items;

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

    public void setPath(String path) {
        this.path = path;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public List<Item> getCatalogItems() {
        return catalogItems;
    }

    public Catalog load() {
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

    public String getCatalogName() {
        return catalogName;
    }
}

