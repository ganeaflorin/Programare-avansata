package optional.exceptions;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException() {
        super("Please enter a valid command.");
    }
}
