package com.anfelisa.test.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.MyTestData;

public class LoadPrivateTestCommand extends AbstractLoadPrivateTestCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateTestCommand.class);

	public LoadPrivateTestCommand(MyTestData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadPrivateTestCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */
