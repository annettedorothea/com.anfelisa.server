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

	public void sendEmail(String to, String subject, String message) {
		if (ServerConfiguration.TEST.equals(App.getMode())) {
			return;
		}
		try {
			Email email = new SimpleEmail();
			email.setHostName(emailConfiguration.getHost());
			email.setSmtpPort(emailConfiguration.getPort());
			email.setAuthenticator(
					new DefaultAuthenticator(emailConfiguration.getUser(), emailConfiguration.getPassword()));
			email.setStartTLSEnabled(emailConfiguration.isTls());
			email.setFrom(emailConfiguration.getUser());
			email.setMsg(message);
			if (ServerConfiguration.LIVE.equals(App.getMode())) {
				email.addTo(to);
				email.setSubject(subject);
			} else {
				email.addTo(emailConfiguration.getUser());
				email.setSubject("to " +  to + " subject " + subject);
			}
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
			throw new WebApplicationException("failedToSendEmail", Response.Status.BAD_REQUEST);
		}
	}
	
	public void sendAdminEmail(String subject, String message) {
		try {
			Email email = new SimpleEmail();
			email.setHostName(emailConfiguration.getHost());
			email.setSmtpPort(emailConfiguration.getPort());
			email.setAuthenticator(
					new DefaultAuthenticator(emailConfiguration.getUser(), emailConfiguration.getPassword()));
			email.setStartTLSEnabled(true);
			email.setFrom(emailConfiguration.getUser());
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(emailConfiguration.getUser());
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
			throw new WebApplicationException("failedToSendEmail", Response.Status.BAD_REQUEST);
		}
	}
	
	public String getLocalhost() {
		return emailConfiguration.getLocalhost();
	}
}
