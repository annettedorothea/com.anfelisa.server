package com.anfelisa.result.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.result.data.MyResultData;

public class LoadResultCommand extends AbstractLoadResultCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadResultCommand.class);

	public LoadResultCommand(MyResultData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadResultCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */
