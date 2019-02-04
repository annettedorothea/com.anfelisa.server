package com.anfelisa.category.actions;

import java.util.List;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.models.IUserWithAccessModel;

public class GetUsersWithAccessAction extends AbstractGetUsersWithAccessAction {

	static final Logger LOG = LoggerFactory.getLogger(GetUsersWithAccessAction.class);

	public GetUsersWithAccessAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest(Handle readonlyHandle) {
		List<IUserWithAccessModel> users = daoProvider.getUserAccessToCategoryDao().selectByCategoryId(readonlyHandle, this.actionData.getCategoryId());
		this.actionData.setUserList(users);
	}


	@Override
	public void initActionData() {
	}

}

/*       S.D.G.       */
