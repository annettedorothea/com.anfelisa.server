package com.anfelisa.user.commands;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.IUserRegistrationData;

public class SendRegistrationEmailCommand extends AbstractSendRegistrationEmailCommand {

	static final Logger LOG = LoggerFactory.getLogger(SendRegistrationEmailCommand.class);

	public SendRegistrationEmailCommand(IUserRegistrationData commandData, IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(commandData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
