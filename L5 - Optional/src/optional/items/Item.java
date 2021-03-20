package optional.items;

import java.nio.file.Path;

public abstract class Item {
    protected String name;
    protected Path path;

    public Item() {
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
