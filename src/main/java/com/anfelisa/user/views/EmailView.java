package com.anfelisa.user.views;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.models.ForgotPasswordModel;
import com.anfelisa.user.models.UserRegistrationModel;

import de.acegen.Data;
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

	public void sendForgotPasswordEmail(Data<ForgotPasswordModel> data, PersistenceHandle handle) {
		Locale currentLocale = Locale.forLanguageTag(data.getModel().getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = emailService.getLocalhost() + "#resetpassword/" + data.getModel().getToken();
		Object[] params = { data.getModel().getUsername(), link };
		String message = MessageFormat.format(messages.getString("passwordResetEmailContent"), params);
		String subject = messages.getString("passwordResetEmailHeader");
		
		emailService.sendEmail(data.getModel().getEmail(), subject, message);
	}

	public void sendRegistrationEmail(Data<UserRegistrationModel> data, PersistenceHandle handle) {
		Locale currentLocale = Locale.forLanguageTag(data.getModel().getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = emailService.getLocalhost() + "#confirmemail/" + data.getModel().getUsername() + "/" + data.getModel().getToken();
		Object[] params = { data.getModel().getUsername(), link };
		String message = MessageFormat.format(messages.getString("RegistrationEmailContent"), params);
		String subject = messages.getString("RegistrationEmailHeader");

		emailService.sendEmail(data.getModel().getEmail(), subject, message);
	}

	@Override
	protected boolean canStop() {
		return !emailService.isSending();
	}

}

/* S.D.G. */
