package com.anfelisa.user.views;

import com.anfelisa.user.models.ConfirmEmailModel;
import com.anfelisa.user.models.UserRegistrationModel;

import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class EmailConfirmationView implements IEmailConfirmationView {

	private IDaoProvider daoProvider;

	public EmailConfirmationView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void insert(Data<UserRegistrationModel> data, PersistenceHandle handle) {
		daoProvider.getEmailConfirmationDao().insert(handle, data.getModel().mapToEmailConfirmationModel());
	}

	public void delete(Data<ConfirmEmailModel> data, PersistenceHandle handle) {
		daoProvider.getEmailConfirmationDao().deleteByToken(handle, data.getModel().getToken());
	}

}

/* S.D.G. */
