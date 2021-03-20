package optional.items;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.Year;

public class Book extends Item implements Serializable {
    private String authorName;
    private Year releaseYear;

    public Book(String name, String path, String authorName, Year releaseYear) {
        this.name = name;
        this.path = path;
        this.authorName = authorName;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
