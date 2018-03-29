package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.PasswordUpdateData;

public abstract class AbstractUpdatePasswordCommand extends Command<PasswordUpdateData> {

	protected static final String success = "success";

	public AbstractUpdatePasswordCommand(PasswordUpdateData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.UpdatePasswordCommand", commandParam, databaseHandle);
	}

	public AbstractUpdatePasswordCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.UpdatePasswordCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case success:
			new com.anfelisa.user.events.UpdatePasswordSuccessEvent(this.commandData, databaseHandle).publish();
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
