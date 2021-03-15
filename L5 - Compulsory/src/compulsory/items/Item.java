package compulsory.items;

import java.io.Serializable;
import java.nio.file.Path;

public abstract class Item {
    private String name;
    private Path path;

    public Item(String name, Path path) {
        this.name = name;
        this.path = path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public Path getPath() {
        return path;
    }
}
