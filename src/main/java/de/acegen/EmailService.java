package de.acegen;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {

	private CustomAppConfiguration configuration;

	public EmailService(CustomAppConfiguration configuration) {
		this.configuration = configuration;
	}

	public void sendEmail(String to, String subject, String message) {
		if (Config.DEV.equals(configuration.getConfig().getMode())) {
			return;
		}
		try {
			Email email = new SimpleEmail();
			email.setHostName(configuration.getEmail().getHost());
			email.setSmtpPort(configuration.getEmail().getPort());
			email.setAuthenticator(
					new DefaultAuthenticator(configuration.getEmail().getUser(),
							configuration.getEmail().getPassword()));
			email.setStartTLSEnabled(configuration.getEmail().isTls());
			email.setFrom(configuration.getEmail().getUser());
			email.setMsg(message);
			email.addTo(to);
			email.setSubject(subject);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
			throw new WebApplicationException("failedToSendEmail", Response.Status.BAD_REQUEST);
		}
	}

	public void sendAdminEmail(String subject, String message) {
		try {
			Email email = new SimpleEmail();
			email.setHostName(configuration.getEmail().getHost());
			email.setSmtpPort(configuration.getEmail().getPort());
			email.setAuthenticator(
					new DefaultAuthenticator(configuration.getEmail().getUser(),
							configuration.getEmail().getPassword()));
			email.setStartTLSEnabled(true);
			email.setFrom(configuration.getEmail().getUser());
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(configuration.getEmail().getUser());
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
			throw new WebApplicationException("failedToSendEmail", Response.Status.BAD_REQUEST);
		}
	}

	public String getLocalhost() {
		return configuration.getEmail().getLocalhost();
	}
}
