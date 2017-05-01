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

	private UserDao userDao = new UserDao();

	private CustomUserDao customUserDao = new CustomUserDao();

	public BiConsumer<UserCreationData, Handle> createUser = (dataContainer, handle) -> {
		String username = userDao.insert(handle, dataContainer);
		dataContainer.setCreatedId(username);
	};

	public BiConsumer<UserRegistrationData, Handle> registerUser = (dataContainer, handle) -> {
		String username = userDao.insert(handle, dataContainer);
		dataContainer.setCreatedId(username);
	};

	public BiConsumer<UserUpdateData, Handle> updateUser = (dataContainer, handle) -> {
		customUserDao.update(handle, dataContainer);
	};

	public BiConsumer<AddCoursesData, Handle> addCourses = (dataContainer, handle) -> {
		customUserDao.addCoursesToUser(handle, dataContainer);
	};

	public BiConsumer<RemoveCourseData, Handle> removeCourse = (dataContainer, handle) -> {
		customUserDao.removeCourseFromUser(handle, dataContainer);
	};

	public BiConsumer<PasswordUpdateData, Handle> updatePassword = (dataContainer, handle) -> {
		customUserDao.updatePassword(handle, dataContainer);
	};

	public BiConsumer<UsernameData, Handle> confirmEmail = (dataContainer, handle) -> {
		customUserDao.confirmEmail(handle, dataContainer.getUsername());
	};

	public BiConsumer<ForgotPasswordData, Handle> sendForgotPasswordEmail = (dataContainer, handle) -> {
		Locale currentLocale = new Locale(dataContainer.getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = EmailService.getLocalhost() + "#profile/newPassword/" + dataContainer.getUsername() + "/"
				+ dataContainer.getPassword();
		Object[] params = { dataContainer.getPrename(), dataContainer.getName(), link };
		String message = MessageFormat.format(messages.getString("passwordResetEmailContent"), params);
		String subject = messages.getString("passwordResetEmailHeader");

		EmailService.sendEmail("annette_pohl@web.de", dataContainer.getEmail(), subject, message);
	};

	public BiConsumer<UserRegistrationData, Handle> sendRegistrationEmail = (dataContainer, handle) -> {
		Locale currentLocale = new Locale(dataContainer.getLanguage());
		ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
		String link = EmailService.getLocalhost() + "#profile/confirmEmail/" + dataContainer.getUsername() + "/"
				+ dataContainer.getPassword();
		Object[] params = { dataContainer.getPrename(), dataContainer.getName(), link };
		String message = MessageFormat.format(messages.getString("RegistrationEmailContent"), params);
		String subject = messages.getString("RegistrationEmailHeader");

		EmailService.sendEmail("annette_pohl@web.de", dataContainer.getEmail(), subject, message);
	};

}

/* S.D.G. */
