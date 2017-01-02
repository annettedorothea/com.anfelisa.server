package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UsernameData;

public class ConfirmEmailCommand extends AbstractConfirmEmailCommand {

	static final Logger LOG = LoggerFactory.getLogger(ConfirmEmailCommand.class);

	public ConfirmEmailCommand(UsernameData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		this.outcome = ok;
	}

}

/*       S.D.G.       */
