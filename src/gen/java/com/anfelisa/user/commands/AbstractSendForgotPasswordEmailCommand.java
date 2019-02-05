package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IForgotPasswordData;

public abstract class AbstractSendForgotPasswordEmailCommand extends Command<IForgotPasswordData> {

	protected static final String ok = "ok";
	protected static final String doesNotExist = "doesNotExist";

	public AbstractSendForgotPasswordEmailCommand(IForgotPasswordData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.user.commands.SendForgotPasswordEmailCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.SendForgotPasswordEmailOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		case doesNotExist:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
