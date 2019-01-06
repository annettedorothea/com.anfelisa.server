package com.anfelisa.category.actions;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.models.IUserWithAccessModel;
import com.anfelisa.ace.IDaoProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.jdbi.v3.core.Jdbi;

public class GetUsersWithAccessAction extends AbstractGetUsersWithAccessAction {

	static final Logger LOG = LoggerFactory.getLogger(GetUsersWithAccessAction.class);

	public GetUsersWithAccessAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest() {
		List<IUserWithAccessModel> users = daoProvider.getUserAccessToCategoryDao().selectByCategoryId(getHandle(), this.actionData.getCategoryId());
		this.actionData.setUserList(users);
	}

}

/*       S.D.G.       */
