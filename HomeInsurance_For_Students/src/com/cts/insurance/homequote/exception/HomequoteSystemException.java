/**
 * HomequoteSystemException
 * Exception class for System exception handling
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.exception;

public class HomequoteSystemException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public HomequoteSystemException(final String message) {
        super(message);
    }
}
