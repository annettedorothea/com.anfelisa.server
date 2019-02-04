package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IConfirmEmailData;

public abstract class AbstractConfirmEmailCommand extends Command<IConfirmEmailData> {

	protected static final String ok = "ok";
	protected static final String alreadyConfirmed = "alreadyConfirmed";

	public AbstractConfirmEmailCommand(IConfirmEmailData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.user.commands.ConfirmEmailCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.ConfirmEmailOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		case alreadyConfirmed:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
