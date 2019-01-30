package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IForgotPasswordData;

public abstract class AbstractForgotPasswordCommand extends Command<IForgotPasswordData> {

	protected static final String ok = "ok";
	protected static final String doesNotExist = "doesNotExist";

	public AbstractForgotPasswordCommand(IForgotPasswordData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.commands.ForgotPasswordCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractForgotPasswordCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.commands.ForgotPasswordCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.ForgotPasswordOkEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		case doesNotExist:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
