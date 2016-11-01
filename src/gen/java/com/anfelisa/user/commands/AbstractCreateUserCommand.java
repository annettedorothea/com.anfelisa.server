package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DatabaseService;

import com.anfelisa.user.data.UserCreationData;

public abstract class AbstractCreateUserCommand extends Command<UserCreationData> {

	protected static final String go = "go";

	public AbstractCreateUserCommand(UserCreationData commandParam, DatabaseHandle databaseHandle) {
		super("CreateUserCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case go:
			new com.anfelisa.user.events.UserCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
