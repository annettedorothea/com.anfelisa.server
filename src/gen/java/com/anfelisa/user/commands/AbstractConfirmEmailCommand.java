package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DaoProvider;

import com.anfelisa.user.data.EmailConfirmationData;

public abstract class AbstractConfirmEmailCommand extends Command<EmailConfirmationData> {

	protected static final String ok = "ok";

	public AbstractConfirmEmailCommand(EmailConfirmationData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.user.commands.ConfirmEmailCommand", commandParam, databaseHandle, daoProvider);
	}

	public AbstractConfirmEmailCommand(DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.user.commands.ConfirmEmailCommand", null, databaseHandle, daoProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.ConfirmEmailOkEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, EmailConfirmationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
