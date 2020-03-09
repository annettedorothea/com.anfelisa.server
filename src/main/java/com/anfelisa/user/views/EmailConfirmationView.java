package com.anfelisa.user.views;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.user.data.IConfirmEmailData;
import com.anfelisa.user.data.IUserRegistrationData;

public class EmailConfirmationView implements IEmailConfirmationView {

	private IDaoProvider daoProvider;

	public EmailConfirmationView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void insert(IUserRegistrationData data, PersistenceHandle handle) {
		daoProvider.getEmailConfirmationDao().insert(handle, data);
	}

	public void delete(IConfirmEmailData data, PersistenceHandle handle) {
		daoProvider.getEmailConfirmationDao().deleteByToken(handle, data.getToken());
	}

}

/* S.D.G. */
