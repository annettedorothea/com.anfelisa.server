package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.RemoveCardFromBoxData;

public abstract class AbstractRemoveCardFromBoxCommand extends Command<RemoveCardFromBoxData> {

	protected static final String deleted = "deleted";

	public AbstractRemoveCardFromBoxCommand(RemoveCardFromBoxData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.RemoveCardFromBoxCommand", commandParam, databaseHandle);
	}

	public AbstractRemoveCardFromBoxCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.RemoveCardFromBoxCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case deleted:
			new com.anfelisa.box.events.CardRemovedFromBoxEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, RemoveCardFromBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
