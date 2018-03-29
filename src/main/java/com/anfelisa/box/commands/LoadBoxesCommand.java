package com.anfelisa.box.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxListData;

public class LoadBoxesCommand extends AbstractLoadBoxesCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadBoxesCommand.class);

	public LoadBoxesCommand(BoxListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadBoxesCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */
