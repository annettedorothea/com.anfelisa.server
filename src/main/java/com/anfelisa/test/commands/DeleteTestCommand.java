package com.anfelisa.test.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestIdData;

public class DeleteTestCommand extends AbstractDeleteTestCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteTestCommand.class);

	public DeleteTestCommand(TestIdData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public DeleteTestCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setOutcome(deleted);
	}

}

/*       S.D.G.       */
