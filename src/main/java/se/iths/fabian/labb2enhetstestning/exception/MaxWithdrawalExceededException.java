package se.iths.fabian.labb2enhetstestning.exception;

public class MaxWithdrawalExceededException extends RuntimeException {
    public MaxWithdrawalExceededException(String message) {
        super(message);
    }
}
