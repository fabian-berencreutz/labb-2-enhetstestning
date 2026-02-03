package se.iths.fabian.labb2enhetstestning.exception;

public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(String message) {
        super(message);
    }
}