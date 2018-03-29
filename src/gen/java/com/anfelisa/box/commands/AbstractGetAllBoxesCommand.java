package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.AllBoxesData;

public abstract class AbstractGetAllBoxesCommand extends Command<AllBoxesData> {


	public AbstractGetAllBoxesCommand(AllBoxesData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.GetAllBoxesCommand", commandParam, databaseHandle);
	}

	public AbstractGetAllBoxesCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.GetAllBoxesCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, AllBoxesData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
