package com.anfelisa.test.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestCreationData;

public class UpdateTestCommand extends AbstractUpdateTestCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateTestCommand.class);

	public UpdateTestCommand(TestCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.outcome = updated;
	}

}

/*       S.D.G.       */
