package com.anfelisa.test.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestData;

public class LoadPublicTestCommand extends AbstractLoadPublicTestCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicTestCommand.class);

	public LoadPublicTestCommand(TestData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadPublicTestCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */
