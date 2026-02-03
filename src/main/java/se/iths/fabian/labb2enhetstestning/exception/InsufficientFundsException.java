package se.iths.fabian.labb2enhetstestning.exception;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String message) {
        super(message);
    }
}
