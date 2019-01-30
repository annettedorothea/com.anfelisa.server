package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.IInviteUserData;

public abstract class AbstractInviteUserCommand extends Command<IInviteUserData> {

	protected static final String ok = "ok";
	protected static final String hasAccess = "hasAccess";

	public AbstractInviteUserCommand(IInviteUserData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.InviteUserCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractInviteUserCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.InviteUserCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.category.events.InviteUserOkEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		case hasAccess:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
