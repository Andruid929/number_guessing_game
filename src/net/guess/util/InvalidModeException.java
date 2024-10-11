package net.guess.util;

public class InvalidModeException extends IllegalArgumentException {

    public InvalidModeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidModeException(Throwable cause) {
        super(cause);
    }

    public InvalidModeException() {
        super();
    }

    public InvalidModeException(String s) {
        super("Options are Easy, Mid, Hard, GGs");
    }
}
