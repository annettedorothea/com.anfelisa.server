package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.DeleteUserData;

public abstract class AbstractDeleteUserCommand extends Command<DeleteUserData> {

	protected static final String ok = "ok";

	public AbstractDeleteUserCommand(DeleteUserData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.DeleteUserCommand", commandParam, databaseHandle);
	}

	public AbstractDeleteUserCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.DeleteUserCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.DeleteUserOkEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, DeleteUserData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
