package optional.commands;

import optional.items.Catalog;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;

public class LoadCommand extends GenericCommand {
    public LoadCommand(Catalog catalog) {
        super(catalog);
    }

    public Catalog load(String path) {
        try {

            FileInputStream fileIn = new FileInputStream(path);
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
