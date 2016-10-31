package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DatabaseService;

import com.anfelisa.user.data.RegistrationData;

public abstract class AbstractRegisterUserCommand extends Command<RegistrationData> {

	protected static final String go = "go";

	public AbstractRegisterUserCommand(RegistrationData commandParam, DatabaseHandle databaseHandle) {
		super("RegisterUserCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case go:
			new com.anfelisa.user.events.UserRegisteredEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
