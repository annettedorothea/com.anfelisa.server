package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UserUpdateData;

public class UpdateUserCommand extends AbstractUpdateUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateUserCommand.class);

	public UpdateUserCommand(UserUpdateData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		this.outcome = success;
	}

}

/*       S.D.G.       */
