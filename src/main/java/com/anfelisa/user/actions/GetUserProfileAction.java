package com.anfelisa.user.actions;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.models.IUserModel;

public class GetUserProfileAction extends AbstractGetUserProfileAction {

	static final Logger LOG = LoggerFactory.getLogger(GetUserProfileAction.class);

	public GetUserProfileAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest() {
		IUserModel user = daoProvider.getUserDao().selectByUsername(getHandle(), actionData.getUsername());
		actionData.setEmail(user.getEmail());
		actionData.setEmailConfirmed(user.getEmailConfirmed());
	}

}

/*       S.D.G.       */
