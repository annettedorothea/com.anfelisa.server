package com.anfelisa.user.views;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.EmailService;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.data.UserRegistrationData;

@SuppressWarnings("all")
public class EmailView {

	private IDaoProvider daoProvider;

	private EmailService emailService;

	public EmailView(IDaoProvider daoProvider, EmailService emailService) {
		super();
		this.daoProvider = daoProvider;
		this.emailService = emailService;
	}

	public BiConsumer<ForgotPasswordData, Handle> sendForgotPasswordEmail = (dataContainer, handle) -> {
		Locale currentLocale = new Locale(dataContainer.getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = emailService.getLocalhost() + "#resetpassword/" + dataContainer.getToken();
		Object[] params = { dataContainer.getUsername(), link };
		String message = MessageFormat.format(messages.getString("passwordResetEmailContent"), params);
		String subject = messages.getString("passwordResetEmailHeader");

		emailService.sendEmail("annette@anfelisa.de", dataContainer.getEmail(), subject, message);
	};

	public BiConsumer<UserRegistrationData, Handle> sendRegistrationEmail = (dataContainer, handle) -> {
		Locale currentLocale = new Locale(dataContainer.getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = emailService.getLocalhost() + "#confirmemail/" + dataContainer.getUsername() + "/"
				+ dataContainer.getToken();
		Object[] params = { dataContainer.getUsername(), link };
		String message = MessageFormat.format(messages.getString("RegistrationEmailContent"), params);
		String subject = messages.getString("RegistrationEmailHeader");

		emailService.sendEmail("annette@anfelisa.de", dataContainer.getEmail(), subject, message);
	};

}

/* S.D.G. */
