package com.anfelisa.user.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceConnection;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.ace.ViewProvider;

public class UsernameAvailableAction extends AbstractUsernameAvailableAction {

	static final Logger LOG = LoggerFactory.getLogger(UsernameAvailableAction.class);

	public UsernameAvailableAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super(persistenceConnection,appConfiguration, daoProvider, viewProvider, e2e);
	}


	protected void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		if (daoProvider.getUserDao().selectByUsername(readonlyHandle,
				this.actionData.getUsername()) == null) {
			this.actionData.setAvailable(true);
		} else {
			this.actionData.setAvailable(false);
		}
	}


	@Override
	public void initActionData() {
	}


}

/*       S.D.G.       */
