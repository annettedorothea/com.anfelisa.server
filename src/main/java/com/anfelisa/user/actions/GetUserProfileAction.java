package com.anfelisa.user.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceConnection;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.models.IUserModel;

public class GetUserProfileAction extends AbstractGetUserProfileAction {

	static final Logger LOG = LoggerFactory.getLogger(GetUserProfileAction.class);

	public GetUserProfileAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super(persistenceConnection,appConfiguration, daoProvider, viewProvider, e2e);
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
