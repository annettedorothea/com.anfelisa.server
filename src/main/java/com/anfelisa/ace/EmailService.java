package com.anfelisa.ace;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {

	private EmailConfiguration emailConfiguration;

	public EmailService(EmailConfiguration emailConfiguration) {
		this.emailConfiguration = emailConfiguration;
	}

	public void sendEmail(String from, String to, String subject, String message) {
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
			throw new WebApplicationException("failedToSendEmail", Response.Status.BAD_REQUEST);
		}
	}
	
	public String getLocalhost() {
		return emailConfiguration.getLocalhost();
	}
}
