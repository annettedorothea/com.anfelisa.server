package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.LoginData;

public abstract class AbstractLoginCommand extends Command<LoginData> {

	protected static final String success = "success";

	public AbstractLoginCommand(LoginData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.LoginCommand", commandParam, databaseHandle);
	}

	public AbstractLoginCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.LoginCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case success:
			new com.anfelisa.user.events.LoginSuccessEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, LoginData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
