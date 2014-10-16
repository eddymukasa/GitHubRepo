package com.eddy.cribz.bookingSystem.core.email;


/**
 * This class provides constants used by the {@link EmailServiceImpl}. Some of
 * the constants provided here are the property names for the different settings
 * used in configuring the {@link JavaMailSender} instance
 * 
 */
/**
 * @author Planet Dev002
 *
 */
public class EmailServiceConstants {

	/**
	 * email attachment folder for the email folder
	 */
	public static final String MAIL_SENDER_ATTACHMENT_FOLDER_PROPERTY = "mail_sender.attachment_folder";

	/**
	 * encoding property name for the mail sender
	 */
	public static final String MAIL_SENDER_DEFAULT_ENCODING_PROPERTY = "mail_sender.encoding";

	/**
	 * host property name for the mail sender
	 */
	public static final String MAIL_SENDER_HOST_PROPERTY = "mail_sender.host";

	/**
	 * password property name for the mail sender. Value is the password for the
	 * account at the mail host
	 */
	public static final String MAIL_SENDER_PASSWORD_PROPERTY = "mail_sender.password";

	/**
	 * port property name for the mail sender
	 */
	public static final String MAIL_SENDER_PORT_PROPERTY = "mail_sender.port";

	/**
	 * protocol property name for the mail sender
	 */
	public static final String MAIL_SENDER_PROTOCOL_PROPERTY = "mail_sender.protocol";

	/**
	 * username property name for the mail sender. Value is the username for the
	 * account at the mail host
	 */
	public static final String MAIL_SENDER_USERNAME_PROPERTY = "mail_sender.username";
}
