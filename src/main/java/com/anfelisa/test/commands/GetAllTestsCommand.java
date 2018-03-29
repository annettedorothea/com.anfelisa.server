package com.anfelisa.test.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.SimpleTestListData;

public class GetAllTestsCommand extends AbstractGetAllTestsCommand {

	static final Logger LOG = LoggerFactory.getLogger(GetAllTestsCommand.class);

	public GetAllTestsCommand(SimpleTestListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public GetAllTestsCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */
