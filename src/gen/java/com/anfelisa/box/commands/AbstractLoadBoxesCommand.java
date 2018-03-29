package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.BoxListData;

public abstract class AbstractLoadBoxesCommand extends Command<BoxListData> {


	public AbstractLoadBoxesCommand(BoxListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.LoadBoxesCommand", commandParam, databaseHandle);
	}

	public AbstractLoadBoxesCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.LoadBoxesCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, BoxListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
