package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.PasswordUpdateData;

public abstract class AbstractUpdatePasswordCommand extends Command<PasswordUpdateData> {

	protected static final String success = "success";

	public AbstractUpdatePasswordCommand(PasswordUpdateData commandParam, DatabaseHandle databaseHandle) {
		super("UpdatePasswordCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case success:
			new com.anfelisa.user.events.PasswordUpdatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
