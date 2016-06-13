package com.epam.mishachess.task.second.exception;

/**
 * @author Mikhail Sadovsky
 *
 */
public class IllegalEmailValidationException extends Exception {

    public IllegalEmailValidationException() {
	super();
    }

    public IllegalEmailValidationException(String message) {
	super(message);
    }

    public IllegalEmailValidationException(String message, Throwable cause) {
	super(message, cause);
    }
}
