package application.port;

public class UnableToReceiveException extends Exception {
    public UnableToReceiveException(String message) {
        super(message);
    }
}
