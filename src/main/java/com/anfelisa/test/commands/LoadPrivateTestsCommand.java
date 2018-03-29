package com.anfelisa.test.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.MyTestListData;

public class LoadPrivateTestsCommand extends AbstractLoadPrivateTestsCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateTestsCommand.class);

	public LoadPrivateTestsCommand(MyTestListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadPrivateTestsCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */
