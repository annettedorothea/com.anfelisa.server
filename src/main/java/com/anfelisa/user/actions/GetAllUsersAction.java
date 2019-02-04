package com.anfelisa.user.actions;

import java.util.List;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.Roles;
import com.anfelisa.user.models.IUserModel;

public class GetAllUsersAction extends AbstractGetAllUsersAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllUsersAction.class);

	public GetAllUsersAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest(Handle readonlyHandle) {
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
