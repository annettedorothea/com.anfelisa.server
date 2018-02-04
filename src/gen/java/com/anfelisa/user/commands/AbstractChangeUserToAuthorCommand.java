package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToAuthorCommand extends Command<ChangeUserRoleData> {

	protected static final String ok = "ok";

	public AbstractChangeUserToAuthorCommand(ChangeUserRoleData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.ChangeUserToAuthorCommand", commandParam, databaseHandle);
	}

	public AbstractChangeUserToAuthorCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.ChangeUserToAuthorCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.ChangeUserToAuthorEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, ChangeUserRoleData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
