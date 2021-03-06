package com.anfelisa.user.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetUserProfileAction extends AbstractGetUserProfileAction {

	static final Logger LOG = LoggerFactory.getLogger(GetUserProfileAction.class);

	public GetUserProfileAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(persistenceConnection,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		IUserModel user = daoProvider.getUserDao().selectByUsername(readonlyHandle, actionData.getUsername());
		actionData.setEmail(user.getEmail());
		actionData.setEmailConfirmed(user.getEmailConfirmed());
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
