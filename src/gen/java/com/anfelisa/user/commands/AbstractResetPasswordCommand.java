package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.PasswordUpdateData;

public abstract class AbstractResetPasswordCommand extends Command<PasswordUpdateData> {

	protected static final String ok = "ok";

	public AbstractResetPasswordCommand(PasswordUpdateData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.ResetPasswordCommand", commandParam, databaseHandle);
	}

	public AbstractResetPasswordCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.ResetPasswordCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.ResetPasswordOkEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, PasswordUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
