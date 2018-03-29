package com.anfelisa.test.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestListData;

public class LoadPublicTestsCommand extends AbstractLoadPublicTestsCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicTestsCommand.class);

	public LoadPublicTestsCommand(TestListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadPublicTestsCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */
