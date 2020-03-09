package com.anfelisa.user.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceConnection;
import com.anfelisa.ace.PersistenceHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.Roles;
import com.anfelisa.user.models.IUserModel;

public class GetAllUsersAction extends AbstractGetAllUsersAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllUsersAction.class);

	public GetAllUsersAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super(persistenceConnection,appConfiguration, daoProvider, viewProvider, e2e);
	}


	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		if (!Roles.ADMIN.equals(this.actionData.getRole())) {
			throwUnauthorized();
		}
		List<IUserModel> users = daoProvider.getUserDao().selectAll(readonlyHandle);
		this.actionData.setUserList(users);
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
