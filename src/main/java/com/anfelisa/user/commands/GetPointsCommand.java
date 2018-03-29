package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.PointsData;

public class GetPointsCommand extends AbstractGetPointsCommand {

	static final Logger LOG = LoggerFactory.getLogger(GetPointsCommand.class);

	public GetPointsCommand(PointsData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public GetPointsCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */
