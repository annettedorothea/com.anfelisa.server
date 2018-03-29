package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UsernameAvailableData;

public class UsernameAvailableCommand extends AbstractUsernameAvailableCommand {

	static final Logger LOG = LoggerFactory.getLogger(UsernameAvailableCommand.class);

	public UsernameAvailableCommand(UsernameAvailableData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public UsernameAvailableCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */
