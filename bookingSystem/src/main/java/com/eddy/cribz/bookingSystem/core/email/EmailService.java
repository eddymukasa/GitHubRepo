package com.eddy.cribz.bookingSystem.core.email;

import java.io.File;


/**
 * @author Planet Dev002
 *
 */
public interface EmailService {

	/**
	 * queues an email for sending using the given parameters
	 * 
	 * @param from
	 *            the source email address
	 * @param to
	 *            the destination email address
	 * @param subject
	 *            the subject of the email.
	 * @param message
	 *            the body of the email message
	 */
	void queueEmail(String from, String to, String subject, String message);

	/**
	 * queues an email for sending using the given parameters
	 * 
	 * @param from
	 *            the source email address
	 * @param to
	 *            the destination email address
	 * @param subject
	 *            the subject of the email message
	 * @param message
	 *            the body of the email
	 * @param isHtml
	 *            whether this is an html message i.e. whether to apply content
	 *            type "text/html" for an HTML email otherwise the default
	 *            content type "text/plain" will be used.
	 */
	void queueEmail(String from, String to, String subject, String message,
			boolean isHtml);

	/**
	 * queues an email using the given parameters
	 * 
	 * @param from
	 *            the source email address
	 * @param to
	 *            an array of email addresses to which to send the email.
	 * @param subject
	 *            the subject of the email message
	 * @param message
	 *            the body of the email message.
	 */
	void queueEmail(String from, String[] to, String subject, String message);

	/**
	 * queues an email for sending using the given parameters
	 * 
	 * @param from
	 *            the source email address
	 * @param to
	 *            an array of email addresses to which to send the email message
	 * @param subject
	 *            the subject of the email message
	 * @param message
	 *            the body of the email.
	 * @param isHtml
	 *            whether this is an html message i.e. whether to apply content
	 *            type "text/html" for an HTML email otherwise the default
	 *            content type "text/plain" will be used.
	 */
	void queueEmail(String from, String[] to, String subject, String message,
			boolean isHtml);

	/**
	 * sends an email using the given parameters
	 * 
	 * @param from
	 *            the source email address
	 * @param to
	 *            the destination email address
	 * @param subject
	 *            the subject of the email.
	 * @param message
	 *            the body of the email message.
	 * @throws EmailSendingFailedException
	 *             if the sending operation fails.
	 */
	void sendEmail(String from, String to, String subject, String message)
			throws EmailSendingFailedException;

	/**
	 * sends an email using the given parameters
	 * 
	 * @param from
	 *            the source email address
	 * @param to
	 *            the destination email address
	 * @param subject
	 *            the subject of the email message
	 * @param message
	 *            the body of the email message
	 * @param isHtml
	 *            where this is an html message i.e. whether to apply content
	 *            type "text/html" for an HTML mail otherwise the default
	 *            content type ("text/plain") will be used.
	 * @throws EmailSendingFailedException
	 *             if the sending operation fails.
	 */
	void sendEmail(String from, String to, String subject, String message,
			boolean isHtml) throws EmailSendingFailedException;

	/**
	 * sends an email using the given parameters
	 * 
	 * @param from
	 *            the source email address
	 * @param to
	 *            an array of email address to which to send the email.
	 * @param subject
	 *            the subject of the email message
	 * @param message
	 *            the body of the email message
	 * @throws EmailSendingFailedException
	 *             if the sending operation fails.
	 */
	void sendEmail(String from, String[] to, String subject, String message)
			throws EmailSendingFailedException;

	/**
	 * sends an email using the given parameters
	 * 
	 * @param from
	 *            the source email address
	 * @param to
	 *            an array of email address to which the email message will be
	 *            sent.
	 * @param subject
	 *            the subject of the email message
	 * @param message
	 *            the body of the email message
	 * @param isHtml
	 *            where this is an html message i.e. whether to apply content
	 *            type "text/html" for an HTML mail otherwise the default
	 *            content type ("text/plain") will be used.
	 * @throws EmailSendingFailedException
	 *             if the sending operation fails.
	 */
	void sendEmail(String from, String[] to, String subject, String message,
			boolean isHtml) throws EmailSendingFailedException;

	/**
	 * @param from
	 * @param to
	 * @param subject
	 * @param message
	 * @param file
	 * @throws EmailSendingFailedException
	 */
	void sendEmailWithAttachment(String from, String to, String subject,
			String message, File file, boolean isHtml)
			throws EmailSendingFailedException;
	
	/**
	 * @param from
	 * @param to
	 * @param subject
	 * @param message
	 * @param file
	 * @param isHtml
	 * @throws EmailSendingFailedException 
	 */
	public void sendEmailsWithAttachment(String from, String[] to, String subject,
			String message, File file, boolean isHtml) throws EmailSendingFailedException;

}
