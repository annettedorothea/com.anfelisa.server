package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.DeleteBoxData;

public abstract class AbstractDeleteBoxCommand extends Command<DeleteBoxData> {

	protected static final String deleted = "deleted";

	public AbstractDeleteBoxCommand(DeleteBoxData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.DeleteBoxCommand", commandParam, databaseHandle);
	}

	public AbstractDeleteBoxCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.DeleteBoxCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case deleted:
			new com.anfelisa.box.events.DeleteBoxDeletedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, DeleteBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
