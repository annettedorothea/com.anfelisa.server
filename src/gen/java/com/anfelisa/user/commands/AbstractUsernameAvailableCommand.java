package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.UsernameAvailableData;

public abstract class AbstractUsernameAvailableCommand extends Command<UsernameAvailableData> {


	public AbstractUsernameAvailableCommand(UsernameAvailableData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.UsernameAvailableCommand", commandParam, databaseHandle);
	}

	public AbstractUsernameAvailableCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.UsernameAvailableCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, UsernameAvailableData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
