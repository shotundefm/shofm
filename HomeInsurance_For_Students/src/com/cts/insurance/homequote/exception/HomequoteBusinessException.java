/**
 * HomequoteBusinessException
 * Exception class for Business exception handling
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.exception;

public class HomequoteBusinessException extends Exception{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public HomequoteBusinessException(final String message) {
        super(message);
    }

}
