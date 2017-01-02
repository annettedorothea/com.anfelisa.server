package com.anfelisa.user.views;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.EmailService;
import com.anfelisa.user.data.AddCoursesData;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.data.PasswordUpdateData;
import com.anfelisa.user.data.RemoveCourseData;
import com.anfelisa.user.data.UserCreationData;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.data.UserUpdateData;
import com.anfelisa.user.data.UsernameData;
import com.anfelisa.user.models.CustomUserDao;
import com.anfelisa.user.models.UserDao;

public class UserView {

	public BiConsumer<UserCreationData, Handle> createUser = (dataContainer, handle) -> {
		UserDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

	public BiConsumer<UserRegistrationData, Handle> registerUser = (dataContainer, handle) -> {
		UserDao.insert(handle, dataContainer, dataContainer.getSchema());
	};
	
	public BiConsumer<UserUpdateData, Handle> updateUser = (dataContainer, handle) -> {
		CustomUserDao.update(handle, dataContainer, dataContainer.getSchema());
	};
	
	public BiConsumer<AddCoursesData, Handle> addCourses = (dataContainer, handle) -> {
		CustomUserDao.addCoursesToUser(handle, dataContainer, dataContainer.getSchema());
	};
	
	public BiConsumer<RemoveCourseData, Handle> removeCourse = (dataContainer, handle) -> {
		CustomUserDao.removeCourseFromUser(handle, dataContainer, dataContainer.getSchema());
	};
	
	public BiConsumer<PasswordUpdateData, Handle> updatePassword = (dataContainer, handle) -> {
		CustomUserDao.updatePassword(handle, dataContainer, dataContainer.getSchema());
	};
	
	public BiConsumer<UsernameData, Handle> confirmEmail = (dataContainer, handle) -> {
		CustomUserDao.confirmEmail(handle, dataContainer.getUsername(), dataContainer.getSchema());
	};
	
	public BiConsumer<ForgotPasswordData, Handle> sendForgotPasswordEmail = (dataContainer, handle) -> {
		Locale currentLocale = new Locale(dataContainer.getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = EmailService.getLocalhost() + "#profile/newPassword/" + dataContainer.getUsername() + "/" + dataContainer.getPassword();
		Object[] params = { dataContainer.getPrename(),
				dataContainer.getName(), link };
		String message = MessageFormat.format(messages.getString("passwordResetEmailContent"), params);
		String subject = messages.getString("passwordResetEmailHeader");
		
		EmailService.sendEmail("info@anfelisa.com", dataContainer.getEmail(), subject, message);
	};
	
	public BiConsumer<UserRegistrationData, Handle> sendRegistrationEmail = (dataContainer, handle) -> {
		Locale currentLocale = new Locale(dataContainer.getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = EmailService.getLocalhost() + "#profile/confirmEmail/" + dataContainer.getUsername() + "/" + dataContainer.getPassword();
		Object[] params = { dataContainer.getPrename(),
				dataContainer.getName(), link };
		String message = MessageFormat.format(messages.getString("RegistrationEmailContent"), params);
		String subject = messages.getString("RegistrationEmailHeader");
		
		EmailService.sendEmail("info@anfelisa.com", dataContainer.getEmail(), subject, message);
	};
	
}

/*                    S.D.G.                    */
