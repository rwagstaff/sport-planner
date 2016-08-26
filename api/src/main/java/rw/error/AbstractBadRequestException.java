package rw.error;

public abstract class AbstractBadRequestException extends RuntimeException {

    protected AbstractBadRequestException(String message) {
        super(message);
    }
}
