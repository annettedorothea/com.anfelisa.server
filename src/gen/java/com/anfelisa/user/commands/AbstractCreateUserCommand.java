package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.UserCreationData;

public abstract class AbstractCreateUserCommand extends Command<UserCreationData> {

	protected static final String go = "go";

	public AbstractCreateUserCommand(UserCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.CreateUserCommand", commandParam, databaseHandle);
	}

	public AbstractCreateUserCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.CreateUserCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case go:
			new com.anfelisa.user.events.UserCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, UserCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
