package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToPremiumCommand extends Command<ChangeUserRoleData> {

	protected static final String ok = "ok";

	public AbstractChangeUserToPremiumCommand(ChangeUserRoleData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.ChangeUserToPremiumCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case ok:
			new com.anfelisa.user.events.ChangeUserToPremiumEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */
