package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToPremiumCommand extends Command<ChangeUserRoleData> {

	protected static final String ok = "ok";

	public AbstractChangeUserToPremiumCommand(ChangeUserRoleData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.ChangeUserToPremiumCommand", commandParam, databaseHandle);
	}

	public AbstractChangeUserToPremiumCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.ChangeUserToPremiumCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.ChangeUserToPremiumEvent(this.commandData, databaseHandle).publish();
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
