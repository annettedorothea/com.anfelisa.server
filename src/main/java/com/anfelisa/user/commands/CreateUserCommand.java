package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UserCreationData;

public class CreateUserCommand extends AbstractCreateUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateUserCommand.class);

	public CreateUserCommand(UserCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
	}

}

/*       S.D.G.       */
