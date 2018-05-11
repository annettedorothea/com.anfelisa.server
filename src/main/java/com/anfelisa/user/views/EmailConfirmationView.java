package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.user.data.EmailConfirmationData;
import com.anfelisa.user.data.UserRegistrationData;

@SuppressWarnings("all")
public class EmailConfirmationView {

	private DaoProvider daoProvider;
	
	public EmailConfirmationView(DaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<UserRegistrationData, Handle> insert = (dataContainer, handle) -> {
		daoProvider.getEmailConfirmationDao().insert(handle, dataContainer);
	};

	public BiConsumer<EmailConfirmationData, Handle> delete = (dataContainer, handle) -> {
		daoProvider.getEmailConfirmationDao().deleteByToken(handle, dataContainer.getToken());
	};
	
}

/*                    S.D.G.                    */
