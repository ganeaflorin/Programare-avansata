package compulsory.items;

import java.io.Serializable;
import java.nio.file.Path;

public abstract class Item implements Serializable {
    protected String name;
    protected String path;

    public Item() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
