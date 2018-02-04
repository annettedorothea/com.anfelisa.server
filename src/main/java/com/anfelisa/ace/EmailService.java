package com.anfelisa.ace;

import javax.ws.rs.WebApplicationException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {

	private static EmailConfiguration emailConfiguration;

	public static void setEmailConfiguration(EmailConfiguration emailConfiguration) {
		EmailService.emailConfiguration = emailConfiguration;
	}

	public static void sendEmail(String from, String to, String subject, String message) {
		try {
			Email email = new SimpleEmail();
			email.setHostName(emailConfiguration.getHost());
			email.setSmtpPort(emailConfiguration.getPort());
			email.setAuthenticator(
					new DefaultAuthenticator(emailConfiguration.getUser(), emailConfiguration.getPassword()));
			email.setStartTLSEnabled(true);
			email.setFrom(from);
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(to);
			email.send();
		} catch (EmailException e) {
			throw new WebApplicationException(e);
		}
	}
	
	public static String getLocalhost() {
		return emailConfiguration.getLocalhost();
	}
}
