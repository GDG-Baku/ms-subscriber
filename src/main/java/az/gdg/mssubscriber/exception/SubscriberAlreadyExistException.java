package az.gdg.mssubscriber.exception;

public class SubscriberAlreadyExistException extends RuntimeException {
    public SubscriberAlreadyExistException(String message) {
        super(message);
    }
}
