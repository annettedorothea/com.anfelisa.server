package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DaoProvider;

import com.anfelisa.user.data.ForgotPasswordData;

public abstract class AbstractForgotPasswordCommand extends Command<ForgotPasswordData> {

	protected static final String ok = "ok";
	protected static final String doesNotExist = "doesNotExist";

	public AbstractForgotPasswordCommand(ForgotPasswordData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.user.commands.ForgotPasswordCommand", commandParam, databaseHandle, daoProvider);
	}

	public AbstractForgotPasswordCommand(DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.user.commands.ForgotPasswordCommand", null, databaseHandle, daoProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.ForgotPasswordOkEvent(this.commandData, databaseHandle).publish();
			break;
		case doesNotExist:
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
