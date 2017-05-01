package com.anfelisa.result.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.result.data.ResultCreationData;

public abstract class AbstractCreateResultCommand extends Command<ResultCreationData> {

	protected static final String created = "created";

	public AbstractCreateResultCommand(ResultCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.commands.CreateResultCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.result.events.ResultCreatedEvent(this.commandData, databaseHandle).publish();
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
