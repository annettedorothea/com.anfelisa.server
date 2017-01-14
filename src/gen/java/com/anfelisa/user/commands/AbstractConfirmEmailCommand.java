package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.UsernameData;

public abstract class AbstractConfirmEmailCommand extends Command<UsernameData> {

	protected static final String ok = "ok";

	public AbstractConfirmEmailCommand(UsernameData commandParam, DatabaseHandle databaseHandle) {
		super("ConfirmEmailCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case ok:
			new com.anfelisa.user.events.EmailConfirmedEvent(this.commandData, databaseHandle).publish();
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
