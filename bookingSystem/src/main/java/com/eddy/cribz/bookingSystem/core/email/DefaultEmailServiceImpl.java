package com.eddy.cribz.bookingSystem.core.email;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.eddy.cribz.bookingSystem.model.exceptions.UnexpectedException;

/**
 * @author Planet Dev002
 * 
 */
public class DefaultEmailServiceImpl implements EmailService {
	private class QueueMailSender implements Runnable {
		public void run() {
			/*
			 * this method is used to run the queue
			 */
			try {
				while (true) {
					MimeMessage message = null;
					synchronized (emailQueue) {
						if (log.isDebugEnabled()) {
							log.debug(DefaultEmailServiceImpl.class.getName(),
									"removing email from queue.");
						}
						message = emailQueue.poll();
					}

					if (message != null) {
						try {
							mailSender.send(message);

							if (log.isDebugEnabled()) {
								log.debug(
										DefaultEmailServiceImpl.class.getName(),
										"sleeping email sender thread for 5 seconds.");
							}
						} catch (Throwable e) {
							log.error(null, e);
						}

						/*
						 * sleep for give seconds between each send
						 */
						Thread.sleep(5 * 1000);
					} else {
						if (log.isDebugEnabled()) {
							log.debug(DefaultEmailServiceImpl.class.getName(),
									"no email found in queue.");
							log.debug(DefaultEmailServiceImpl.class.getName(),
									"sleeping email sender thread for 5 minutes.");
						}

						// sleep the thread for one minute.
						Thread.sleep(1 * 60 * 1000);
					}
				}
			} catch (InterruptedException e) {
				log.error(DefaultEmailServiceImpl.class.getName(), e);
			}
		}
	}

	private static final String DEFAULT_CONFIGURATION_FILE_NAME = "EMAIL_SERVICE_DEFAULT_CONFIGURATION.properties";
	private Properties applicationProperties;
	private Queue<MimeMessage> emailQueue = new LinkedList<MimeMessage>();
	private Logger log = LoggerFactory.getLogger(this.getClass());

	private JavaMailSender mailSender;

	/**
	 * Default Constructor
	 */
	public DefaultEmailServiceImpl() {
		super();

		/*
		 * load default configuration will be overriden with system wide
		 * configuration if provided
		 */
		if (this.applicationProperties == null) {

			try {

				log.debug("reading the default email service configurations");
				applicationProperties = PropertiesLoaderUtils
						.loadProperties(new ClassPathResource(
								DEFAULT_CONFIGURATION_FILE_NAME));

			} catch (IOException e) {
				log.error("failed to load the default configuration file", e);
				throw new UnexpectedException(
						"Email Service Initialization failed due to default configuration load failure");
			}
		}
	}

	/**
	 * constructor with initial specified application properties
	 * 
	 * @param applicationProperties
	 */
	public DefaultEmailServiceImpl(Properties applicationProperties) {
		this();
		setApplicationProperties(applicationProperties);
	}

	/**
	 * @return the applicationProperties
	 */
	public Properties getApplicationProperties() {
		return applicationProperties;
	}

	/**
	 * @return the mailSender
	 */
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	/**
	 * Email Service initialization method <br/>
	 * <br/>
	 * This method should only be called if the default implemention of the
	 * {@link JavaMailSenderImpl} is desired. Otherwise it should never be
	 * called. And can never be overriden
	 */
	public final void init() {

		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(this.applicationProperties.getProperty(
				EmailServiceConstants.MAIL_SENDER_HOST_PROPERTY, "127.0.0.1"));

		sender.setPort(Integer.parseInt(this.applicationProperties.getProperty(
				EmailServiceConstants.MAIL_SENDER_PORT_PROPERTY, "25")));

		sender.setProtocol(this.applicationProperties.getProperty(
				EmailServiceConstants.MAIL_SENDER_PROTOCOL_PROPERTY, "smtp"));

		sender.setUsername(this.applicationProperties
				.getProperty(EmailServiceConstants.MAIL_SENDER_USERNAME_PROPERTY));

		sender.setPassword(this.applicationProperties
				.getProperty(EmailServiceConstants.MAIL_SENDER_PASSWORD_PROPERTY));

		// Properties otherProps = new Properties();

		// if (this.applicationProperties.get("mail.smtp.auth") != null)
		sender.getJavaMailProperties().put("mail.smtp.auth",
				this.applicationProperties.get("mail.smtp.auth"));

		// if (this.applicationProperties.get("mail.smtp.starttls.enable") !=
		// null) {
		sender.getJavaMailProperties().put("mail.smtp.starttls.enable",
				this.applicationProperties.get("mail.smtp.starttls.enable"));
		System.out.println("12");
		this.mailSender = sender;

		/*
		 * start the thread to send emails asynchronously
		 */

		Thread thread = new Thread(new QueueMailSender());
		thread.start();
	}

	public void queueEmail(String from, String to, String subject,
			String message) {
		queueEmail(from, new String[] { to }, subject, message, false);
	}

	public void queueEmail(String from, String to, String subject,
			String message, boolean isHtml) {
		queueEmail(from, new String[] { to }, subject, message, isHtml);
	}

	public void queueEmail(String from, String[] to, String subject,
			String message) {
		queueEmail(from, to, subject, message);
	}

	public void queueEmail(String from, String[] to, String subject,
			String message, boolean isHtml) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

			messageHelper.setSubject(subject);
			messageHelper.setTo(to);
			messageHelper.setText(message, isHtml);
			messageHelper.setFrom(from);

			synchronized (emailQueue) {
				emailQueue.add(mimeMessage);
			}
		} catch (Exception ex) {
			log.error(DefaultEmailServiceImpl.class.getName(), ex);
		}
	}

	public void sendEmail(String from, String to, String subject, String message)
			throws EmailSendingFailedException {
		sendEmail(from, new String[] { to }, subject, message);
	}

	public void sendEmail(String from, String to, String subject,
			String message, boolean isHtml) throws EmailSendingFailedException {
		sendEmail(from, new String[] { to }, subject, message, isHtml);
	}

	public void sendEmail(String from, String[] to, String subject,
			String message) throws EmailSendingFailedException {
		sendEmail(from, to, subject, message, false);
	}

	public void sendEmail(String from, String[] to, String subject,
			String message, boolean isHtml) throws EmailSendingFailedException {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

			messageHelper.setSubject(subject);
			messageHelper.setTo(to);
			messageHelper.setText(message, isHtml);
			messageHelper.setFrom(from);

			mailSender.send(mimeMessage);
		} catch (Exception ex) {
			throw new EmailSendingFailedException(ex);
		}
	}

	public void sendEmailWithAttachment(String from, String to, String subject,
			String message, File file, boolean isHtml)
			throws EmailSendingFailedException {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mimeMessage, true);
			messageHelper.setSubject(subject);
			messageHelper.setTo(to);
			messageHelper.setText(message, isHtml);
			messageHelper.setFrom(from);
			messageHelper.addAttachment(file.getName(), file);
			mailSender.send(mimeMessage);
		} catch (Exception ex) {
			throw new EmailSendingFailedException(ex);
		}
	}

	public void sendEmailsWithAttachment(String from, String[] to,
			String subject, String message, File file, boolean isHtml)
			throws EmailSendingFailedException {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mimeMessage, true);
			messageHelper.setSubject(subject);
			messageHelper.setTo(to);
			messageHelper.setText(message, isHtml);
			messageHelper.setFrom(from);
			messageHelper.addAttachment(file.getName(), file);
			mailSender.send(mimeMessage);
		} catch (Exception ex) {
			throw new EmailSendingFailedException(ex);
		}
	}

	/**
	 * @param props
	 *            the applicationProperties to set
	 */
	public void setApplicationProperties(Properties props) {
		if (this.applicationProperties != null && props != null) {
			@SuppressWarnings("unchecked")
			Enumeration<String> keys = (Enumeration<String>) this.applicationProperties
					.propertyNames();
			if (keys != null) {
				while (keys.hasMoreElements()) {
					String key = keys.nextElement();
					String newValue = props.getProperty(key);
					if (newValue != null)
						this.applicationProperties.setProperty(key, newValue);
				}
			}
		} else
			this.applicationProperties = props;
	}

	/**
	 * @param mailSender
	 *            the mailSender to set
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
}
