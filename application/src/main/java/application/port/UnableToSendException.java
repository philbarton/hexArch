package application.port;

public class UnableToSendException extends Exception {
    public UnableToSendException(String message) {
        super(message);
    }
}
