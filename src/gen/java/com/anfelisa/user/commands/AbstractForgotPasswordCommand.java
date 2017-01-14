package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.ForgotPasswordData;

public abstract class AbstractForgotPasswordCommand extends Command<ForgotPasswordData> {

	protected static final String ok = "ok";
	protected static final String userNotFound = "userNotFound";

	public AbstractForgotPasswordCommand(ForgotPasswordData commandParam, DatabaseHandle databaseHandle) {
		super("ForgotPasswordCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case ok:
			new com.anfelisa.user.events.SendEmailEvent(this.commandData, databaseHandle).publish();
			break;
		case userNotFound:
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
