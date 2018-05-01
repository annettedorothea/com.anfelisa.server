package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.BoxCreationData;

public abstract class AbstractUpdateBoxCommand extends Command<BoxCreationData> {

	protected static final String updated = "updated";

	public AbstractUpdateBoxCommand(BoxCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.UpdateBoxCommand", commandParam, databaseHandle);
	}

	public AbstractUpdateBoxCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.UpdateBoxCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case updated:
			new com.anfelisa.box.events.UpdateBoxUpdatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, BoxCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
