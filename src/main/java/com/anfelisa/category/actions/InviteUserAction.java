package com.anfelisa.category.actions;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

public class InviteUserAction extends AbstractInviteUserAction {

	static final Logger LOG = LoggerFactory.getLogger(InviteUserAction.class);

	public InviteUserAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public void initActionData() {
	}


}

/*       S.D.G.       */
