package com.anfelisa.user.views;

import java.util.function.BiConsumer;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.user.data.ConfirmEmailData;
import com.anfelisa.user.data.UserRegistrationData;

@SuppressWarnings("all")
public class EmailConfirmationView {

	private IDaoProvider daoProvider;
	
	public EmailConfirmationView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<UserRegistrationData, Handle> insert = (dataContainer, handle) -> {
		daoProvider.getEmailConfirmationDao().insert(handle, dataContainer);
	};

	public BiConsumer<ConfirmEmailData, Handle> delete = (dataContainer, handle) -> {
		daoProvider.getEmailConfirmationDao().deleteByToken(handle, dataContainer.getToken());
	};
	
}

/*                    S.D.G.                    */
