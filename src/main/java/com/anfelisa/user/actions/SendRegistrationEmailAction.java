package com.anfelisa.user.actions;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.IDaoProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jdbi.v3.core.Jdbi;

public class SendRegistrationEmailAction extends AbstractSendRegistrationEmailAction {

	static final Logger LOG = LoggerFactory.getLogger(SendRegistrationEmailAction.class);

	public SendRegistrationEmailAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	
	public void initActionData() {
		// init not replayable data here
	}

}

/*       S.D.G.       */
