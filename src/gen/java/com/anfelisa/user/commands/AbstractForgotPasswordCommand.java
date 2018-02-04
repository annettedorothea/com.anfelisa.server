package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.ForgotPasswordData;

public abstract class AbstractForgotPasswordCommand extends Command<ForgotPasswordData> {

	protected static final String ok = "ok";
	protected static final String userNotFound = "userNotFound";

	public AbstractForgotPasswordCommand(ForgotPasswordData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.ForgotPasswordCommand", commandParam, databaseHandle);
	}

	public AbstractForgotPasswordCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.ForgotPasswordCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.SendEmailEvent(this.commandData, databaseHandle).publish();
			break;
		case userNotFound:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, ForgotPasswordData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
