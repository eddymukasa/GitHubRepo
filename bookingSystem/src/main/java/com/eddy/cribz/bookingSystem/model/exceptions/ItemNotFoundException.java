package com.eddy.cribz.bookingSystem.model.exceptions;

/**
 * @author Planet Dev002
 *
 */
public class ItemNotFoundException extends GeneralException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2161517352070219039L;

	/**
	 * Default non arg constructor.
	 */
	public ItemNotFoundException() {
	}

	/**
	 * Constructor that takes an argument which is the <code>String</code>
	 * message to display when the exception is thrown.
	 * 
	 * @param message
	 *            message to display when <code>exception</code> is thrown.
	 */
	public ItemNotFoundException(String message) {
		super(message);
	}

	/**
	 * Constructor that takes an argument which is an instance of
	 * <code>throwable</code>. It is the exception that is thrown used to
	 * initialise this exception too.
	 * 
	 * @param throwable
	 *            exception that is thrown.
	 */
	public ItemNotFoundException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * Constructs an instance of the <tt>Class</tt> with a custom message and
	 * the <tt>Exception.</tt>
	 * 
	 * @param message
	 *            Custom message to accompany the exception.
	 * @param cause
	 *            <tt>Exception</tt> that was thrown.
	 */
	public ItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
