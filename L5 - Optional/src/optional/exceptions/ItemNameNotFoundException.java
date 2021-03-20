package optional.exceptions;

public class ItemNameNotFoundException extends RuntimeException {
    public ItemNameNotFoundException() {
        super("Item name not found in catalog.");
    }
}

