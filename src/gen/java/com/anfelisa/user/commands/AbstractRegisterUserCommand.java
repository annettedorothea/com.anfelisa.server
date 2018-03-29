package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.UserRegistrationData;

public abstract class AbstractRegisterUserCommand extends Command<UserRegistrationData> {

	protected static final String ok = "ok";

	public AbstractRegisterUserCommand(UserRegistrationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.RegisterUserCommand", commandParam, databaseHandle);
	}

	public AbstractRegisterUserCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.RegisterUserCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.RegisterUserOkEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, UserRegistrationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
