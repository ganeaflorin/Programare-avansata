package compulsory;

import compulsory.items.Catalog;
import compulsory.items.Item;
import compulsory.items.Song;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Year;

import static compulsory.items.Catalog.save;

public class Main {
    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog("C:\\Users\\andre\\OneDrive\\Desktop\\catalog.txt");

        String path = "C:\\Users\\andre\\Downloads\\Frank Sinatra - That's Life.mp3";
        Item thatsLife = new Song("mafia", Path.of(path), "Frank Sinatra", Year.of(1966));
        catalog.add(thatsLife);
        catalog.play(thatsLife);
        catalog.list();
        save(catalog);

        Catalog catalog2 = new Catalog("C:\\Users\\andre\\OneDrive\\Desktop\\catalog2.txt");

    }
}
