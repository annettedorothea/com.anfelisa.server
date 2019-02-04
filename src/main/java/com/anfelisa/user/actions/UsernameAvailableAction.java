package com.anfelisa.user.actions;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

public class UsernameAvailableAction extends AbstractUsernameAvailableAction {

	static final Logger LOG = LoggerFactory.getLogger(UsernameAvailableAction.class);

	public UsernameAvailableAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected void loadDataForGetRequest(Handle readonlyHandle) {
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
