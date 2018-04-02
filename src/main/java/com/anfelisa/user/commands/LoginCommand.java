package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.LoginData;

public class LoginCommand extends AbstractLoginCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoginCommand.class);

	public LoginCommand(LoginData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setOutcome(success);
		this.commandData.setLoginLogId(this.commandData.getUuid());
	}

}

/* S.D.G. */
