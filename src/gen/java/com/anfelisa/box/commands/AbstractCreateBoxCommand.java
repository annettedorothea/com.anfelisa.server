package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.BoxCreationData;

public abstract class AbstractCreateBoxCommand extends Command<BoxCreationData> {

	protected static final String created = "created";

	public AbstractCreateBoxCommand(BoxCreationData commandParam, DatabaseHandle databaseHandle) {
		super("CreateBoxCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.box.events.BoxCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
	
	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}
}

/*       S.D.G.       */
