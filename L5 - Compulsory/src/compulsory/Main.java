package compulsory;

import compulsory.items.Book;
import compulsory.items.Catalog;
import compulsory.items.Item;
import compulsory.items.Song;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Year;

import static compulsory.items.Catalog.save;

public class Main {
    public static void main(String[] args) throws IOException, YearException {
        Catalog catalog = new Catalog("Catalog 1");
        catalog.setPath("C:\\Users\\andre\\OneDrive\\Desktop\\catalog.txt");
        String path = "C:\\Users\\andre\\Downloads\\Frank Sinatra - That's Life.mp3";
        Song thatsLife = new Song("mafia", Path.of(path), "Frank Sinatra", Year.of(1966));
        Item annaKarenina = new Book("Anna Karenina", null, "Lev Tolstoi", Year.of(1877));
        catalog.add(thatsLife);
        catalog.add(annaKarenina);
        catalog.play(thatsLife);
        catalog.list();
        save(catalog);

        Catalog catalog2 = catalog.load();
        catalog2.setCatalogName("Catalog 2");
        catalog2.list();
        thatsLife.setReleaseYear(-1);
    }
}