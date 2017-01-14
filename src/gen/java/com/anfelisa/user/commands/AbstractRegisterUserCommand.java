package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.UserRegistrationData;

public abstract class AbstractRegisterUserCommand extends Command<UserRegistrationData> {

	protected static final String ok = "ok";

	public AbstractRegisterUserCommand(UserRegistrationData commandParam, DatabaseHandle databaseHandle) {
		super("RegisterUserCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case ok:
			new com.anfelisa.user.events.UserRegisteredEvent(this.commandData, databaseHandle).publish();
			new com.anfelisa.user.events.SendRegistrationEmailEvent(this.commandData, databaseHandle).publish();
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
