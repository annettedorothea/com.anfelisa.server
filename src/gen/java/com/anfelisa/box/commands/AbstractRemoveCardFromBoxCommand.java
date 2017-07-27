package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.RemoveCardFromBoxData;

public abstract class AbstractRemoveCardFromBoxCommand extends Command<RemoveCardFromBoxData> {

	protected static final String deleted = "deleted";

	public AbstractRemoveCardFromBoxCommand(RemoveCardFromBoxData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.RemoveCardFromBoxCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case deleted:
			new com.anfelisa.box.events.CardRemovedFromBoxEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
	
	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

	protected void throwBadRequest() {
		throw new WebApplicationException(Response.Status.BAD_REQUEST);
	}

}

/*       S.D.G.       */
