package optional.commands;

import optional.items.Book;
import optional.items.Catalog;
import optional.items.Item;
import optional.items.Song;

import java.nio.file.Path;
import java.time.Year;

public class AddCommand extends GenericCommand {

    public AddCommand(Catalog catalog) {
        super(catalog);
    }

    public void addSong(String name, String path, String singer, int releaseYear) {
        Song song = new Song(name, Path.of(path), singer, Year.of(releaseYear));
        addItem(song);
    }

    public void addBook(String name, String path, String author, int releaseYear) {
        Book book = new Book(name, Path.of(path), author, Year.of(releaseYear));
        addItem(book);
    }
}
