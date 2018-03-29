package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.PointsData;

public abstract class AbstractGetPointsCommand extends Command<PointsData> {


	public AbstractGetPointsCommand(PointsData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.GetPointsCommand", commandParam, databaseHandle);
	}

	public AbstractGetPointsCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.GetPointsCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, PointsData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
