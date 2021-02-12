package com.anfelisa.user.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetRoleAction extends AbstractGetRoleAction {

	static final Logger LOG = LoggerFactory.getLogger(GetRoleAction.class);

	public GetRoleAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(persistenceConnection,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
