package com.anfelisa.user.views;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;

import javax.ws.rs.WebApplicationException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.skife.jdbi.v2.Handle;

import com.anfelisa.user.data.AddCoursesData;
import com.anfelisa.user.data.PasswordUpdateData;
import com.anfelisa.user.data.RemoveCourseData;
import com.anfelisa.user.data.UserCreationData;
import com.anfelisa.user.data.UserUpdateData;
import com.anfelisa.user.models.CustomUserDao;
import com.anfelisa.user.models.UserDao;

public class UserView {

	public BiConsumer<UserCreationData, Handle> createUser = (dataContainer, handle) -> {
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
	
	public BiConsumer<PasswordUpdateData, Handle> sendForgotPasswordEmail = (dataContainer, handle) -> {
		/*try {
			Locale currentLocale = new Locale(mandatorCreationData.getLocale());
			ResourceBundle messages = ResourceBundle.getBundle("EmailsBundle", currentLocale);
			Email email = new SimpleEmail();
			email.setHostName("mail.your-server.de");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("info@lessontome.com", "bbO254c5u20lOqT0"));
			email.setSSLOnConnect(true);
			email.setFrom("info@lessontome.com");
			email.setSubject(messages.getString("mandatorRegistrationEmailHeader"));
			Object[] params = { mandatorCreationData.getMandator().getPrename(),
					mandatorCreationData.getMandator().getLastname() };
			String message = MessageFormat.format(messages.getString("mandatorRegistrationEmailContent"), params);
			email.setMsg(message);
			// email.addTo(mandatorCreationData.getMandator().getEmail());
			email.addTo("annette_pohl@web.de");
			email.send();
		} catch (EmailException e) {
			throw new WebApplicationException(e);
		}*/
	};
	
}

/*                    S.D.G.                    */
