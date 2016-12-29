package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.ForgotPasswordData;

public class ForgotPasswordCommand extends AbstractForgotPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ForgotPasswordCommand.class);

	public ForgotPasswordCommand(ForgotPasswordData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		if (this.commandParam.getEmail() == null) {
			this.outcome = userNotFound;
		} else {
			this.outcome = ok;
		}
	}

}

/* S.D.G. */
