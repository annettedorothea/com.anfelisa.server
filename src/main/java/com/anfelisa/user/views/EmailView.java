package com.anfelisa.user.views;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.EmailService;
import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.data.UserRegistrationData;

@SuppressWarnings("all")
public class EmailView {

	public static BiConsumer<ForgotPasswordData, Handle> sendForgotPasswordEmail = (dataContainer, handle) -> {
		Locale currentLocale = new Locale(dataContainer.getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = EmailService.getLocalhost() + "#profile/newPassword/" + dataContainer.getUsername() + "/"
				+ dataContainer.getPassword();
		Object[] params = { dataContainer.getUsername(), link };
		String message = MessageFormat.format(messages.getString("passwordResetEmailContent"), params);
		String subject = messages.getString("passwordResetEmailHeader");

		EmailService.sendEmail("annette@anfelisa.de", dataContainer.getEmail(), subject, message);
	};

	public static BiConsumer<UserRegistrationData, Handle> sendRegistrationEmail = (dataContainer, handle) -> {
		Locale currentLocale = new Locale(dataContainer.getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = EmailService.getLocalhost() + "#profile/confirmEmail/" + dataContainer.getUsername() + "/"
				+ dataContainer.getPassword();
		Object[] params = { dataContainer.getUsername(), link };
		String message = MessageFormat.format(messages.getString("RegistrationEmailContent"), params);
		String subject = messages.getString("RegistrationEmailHeader");

		EmailService.sendEmail("annette@anfelisa.de", dataContainer.getEmail(), subject, message);
	};

}

/* S.D.G. */
