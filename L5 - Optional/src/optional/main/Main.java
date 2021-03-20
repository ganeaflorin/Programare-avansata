package optional.main;

import optional.commands.Shell;
import optional.exceptions.YearException;
import optional.items.*;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Year;

public class Main {
    public static void main(String[] args) throws IOException, YearException {
        Catalog catalog = new Catalog("Catalog 1");
        catalog.setPath("C:\\Users\\andre\\OneDrive\\Desktop\\catalog.txt");
        String path = "C:\\Users\\andre\\Downloads\\Frank Sinatra - That's Life.mp3";
        Song thatsLife = new Song("life", Path.of(path), "Frank Sinatra", Year.of(1966));
        Item annaKarenina = new Book("Anna Karenina", null, "Lev Tolstoi", Year.of(1877));
        catalog.add(thatsLife);
        catalog.add(annaKarenina);
        Catalog catalog2 = new Catalog("Catalog 2");
//        catalog2.setCatalogName("Catalog 2");
//        catalog2.list();
//        thatsLife.setReleaseYear(-1);
            Shell shell = new Shell(catalog2);
            shell.getCommands();
    }
}
