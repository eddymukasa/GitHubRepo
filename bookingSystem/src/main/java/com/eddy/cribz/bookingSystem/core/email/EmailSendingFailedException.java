package com.eddy.cribz.bookingSystem.core.email;


/**
 * @author Planet Dev002
 *
 */
public class EmailSendingFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7721322359832416956L;

	/**
	 * 
	 */
	public EmailSendingFailedException() {
		super();
	}

	/**
	 * @param message
	 */
	public EmailSendingFailedException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EmailSendingFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param throwable
	 */
	public EmailSendingFailedException(Throwable throwable) {
		super(throwable);
	}
}
