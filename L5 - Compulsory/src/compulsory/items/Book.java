package compulsory.items;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.Year;

public class Book extends Item implements Serializable {
    private String authorName;
    private Year releaseYear;

    public Book(String name, Path path, String authorName, Year releaseYear) {
        super(name, path);
        this.authorName = authorName;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorName='" + authorName + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
