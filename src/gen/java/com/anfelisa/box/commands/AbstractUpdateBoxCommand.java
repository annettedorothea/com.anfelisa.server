package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.BoxCreationData;

public abstract class AbstractUpdateBoxCommand extends Command<BoxCreationData> {

	protected static final String created = "created";

	public AbstractUpdateBoxCommand(BoxCreationData commandParam, DatabaseHandle databaseHandle) {
		super("UpdateBoxCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.box.events.BoxUpdatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
