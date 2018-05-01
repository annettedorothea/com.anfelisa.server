package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.user.data.EmailConfirmationData;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.models.EmailConfirmationDao;

@SuppressWarnings("all")
public class EmailConfirmationView {

	private static EmailConfirmationDao emailConfirmationDao = new EmailConfirmationDao();
	
	public static BiConsumer<UserRegistrationData, Handle> insert = (dataContainer, handle) -> {
		emailConfirmationDao.insert(handle, dataContainer);
	};

	public static BiConsumer<EmailConfirmationData, Handle> delete = (dataContainer, handle) -> {
		emailConfirmationDao.deleteByToken(handle, dataContainer.getToken());
	};
	
}

/*                    S.D.G.                    */
