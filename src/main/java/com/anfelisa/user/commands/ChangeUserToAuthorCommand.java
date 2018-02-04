package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.ChangeUserRoleData;

public class ChangeUserToAuthorCommand extends AbstractChangeUserToAuthorCommand {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserToAuthorCommand.class);

	public ChangeUserToAuthorCommand(ChangeUserRoleData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
