package com.anfelisa.user.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class UsernameAvailableAction extends AbstractUsernameAvailableAction {

	static final Logger LOG = LoggerFactory.getLogger(UsernameAvailableAction.class);

	public UsernameAvailableAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(persistenceConnection,appConfiguration, daoProvider, viewProvider);
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
