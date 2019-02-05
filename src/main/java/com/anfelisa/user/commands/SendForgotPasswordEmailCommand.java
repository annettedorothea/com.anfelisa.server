package com.anfelisa.user.commands;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.IForgotPasswordData;

public class SendForgotPasswordEmailCommand extends AbstractSendForgotPasswordEmailCommand {

	static final Logger LOG = LoggerFactory.getLogger(SendForgotPasswordEmailCommand.class);

	public SendForgotPasswordEmailCommand(IForgotPasswordData commandData, IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(commandData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
