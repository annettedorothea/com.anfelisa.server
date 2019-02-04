package com.anfelisa.user.actions;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.models.IUserModel;

public class GetRoleAction extends AbstractGetRoleAction {

	static final Logger LOG = LoggerFactory.getLogger(GetRoleAction.class);

	public GetRoleAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest(Handle readonlyHandle) {
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
