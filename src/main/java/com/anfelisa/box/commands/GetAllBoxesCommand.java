package com.anfelisa.box.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.AllBoxesData;

public class GetAllBoxesCommand extends AbstractGetAllBoxesCommand {

	static final Logger LOG = LoggerFactory.getLogger(GetAllBoxesCommand.class);

	public GetAllBoxesCommand(AllBoxesData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public GetAllBoxesCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */
