package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IUserRegistrationData;

public abstract class AbstractRegisterUserCommand extends Command<IUserRegistrationData> {

	protected static final String ok = "ok";

	public AbstractRegisterUserCommand(IUserRegistrationData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.commands.RegisterUserCommand", commandParam, daoProvider, viewProvider);
	}

	public AbstractRegisterUserCommand(IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.commands.RegisterUserCommand", null, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.RegisterUserOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
