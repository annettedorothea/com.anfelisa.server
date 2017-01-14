package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.CardCreationData;

public abstract class AbstractCreateCardCommand extends Command<CardCreationData> {

	protected static final String created = "created";

	public AbstractCreateCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle) {
		super("CreateCardCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.box.events.CardCreatedEvent(this.commandData, databaseHandle).publish();
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
