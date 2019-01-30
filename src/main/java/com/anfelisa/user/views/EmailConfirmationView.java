package com.anfelisa.user.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.user.data.IConfirmEmailData;
import com.anfelisa.user.data.IUserRegistrationData;

public class EmailConfirmationView implements IEmailConfirmationView {

	private IDaoProvider daoProvider;

	public EmailConfirmationView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void insert(IUserRegistrationData data, Handle handle) {
		daoProvider.getEmailConfirmationDao().insert(handle, data);
	}

	public void delete(IConfirmEmailData data, Handle handle) {
		daoProvider.getEmailConfirmationDao().deleteByToken(handle, data.getToken());
	}

}

/* S.D.G. */
