package com.anfelisa.user.views;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.IForgotPasswordData;
import com.anfelisa.user.data.IUserRegistrationData;

import de.acegen.EmailService;
import de.acegen.PersistenceHandle;
import de.acegen.QueuedView;

public class EmailView extends QueuedView implements IEmailView {

	static final Logger LOG = LoggerFactory.getLogger(EmailView.class);

	private EmailService emailService;

	public EmailView(EmailService emailService) {
		super();
		this.emailService = emailService;
	}

	public void sendForgotPasswordEmail(IForgotPasswordData data, PersistenceHandle handle) {
		Locale currentLocale = Locale.forLanguageTag(data.getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = emailService.getLocalhost() + "#resetpassword/" + data.getToken();
		Object[] params = { data.getUsername(), link };
		String message = MessageFormat.format(messages.getString("passwordResetEmailContent"), params);
		String subject = messages.getString("passwordResetEmailHeader");
		
		emailService.sendEmail(data.getEmail(), subject, message);
	}

	public void sendRegistrationEmail(IUserRegistrationData data, PersistenceHandle handle) {
		Locale currentLocale = Locale.forLanguageTag(data.getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = emailService.getLocalhost() + "#confirmemail/" + data.getUsername() + "/" + data.getToken();
		Object[] params = { data.getUsername(), link };
		String message = MessageFormat.format(messages.getString("RegistrationEmailContent"), params);
		String subject = messages.getString("RegistrationEmailHeader");

		emailService.sendEmail(data.getEmail(), subject, message);
	}

	@Override
	protected boolean canStop() {
		return !emailService.isSending();
	}

}

/* S.D.G. */
