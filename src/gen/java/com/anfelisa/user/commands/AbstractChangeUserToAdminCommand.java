package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToAdminCommand extends Command<ChangeUserRoleData> {

	protected static final String ok = "ok";

	public AbstractChangeUserToAdminCommand(ChangeUserRoleData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.ChangeUserToAdminCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case ok:
			new com.anfelisa.user.events.ChangeUserToAdminEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */
