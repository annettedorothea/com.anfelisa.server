package com.anfelisa.user.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.E2E;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetRoleAction extends AbstractGetRoleAction {

	static final Logger LOG = LoggerFactory.getLogger(GetRoleAction.class);

	public GetRoleAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super(persistenceConnection,appConfiguration, daoProvider, viewProvider, e2e);
	}


	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		IUserModel user = daoProvider.getUserDao().selectByUsername(readonlyHandle, actionData.getUsername());
		if (user == null) {
			throwBadRequest("user " + actionData.getUsername() + " not found");
		}
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
