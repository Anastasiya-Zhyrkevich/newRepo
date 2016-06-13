package com.epam.mishachess.task.second.exception;

/**
 * @author Mikhail Sadovsky
 *
 */
public class IllegalDateValidationException extends Exception {

    public IllegalDateValidationException() {
	super();
    }

    public IllegalDateValidationException(String message) {
	super(message);
    }

    public IllegalDateValidationException(String message, Throwable cause) {
	super(message, cause);
    }
}
