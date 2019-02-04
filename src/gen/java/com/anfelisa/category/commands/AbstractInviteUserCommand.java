package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.IInviteUserData;

public abstract class AbstractInviteUserCommand extends Command<IInviteUserData> {

	protected static final String ok = "ok";
	protected static final String hasAccess = "hasAccess";

	public AbstractInviteUserCommand(IInviteUserData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.InviteUserCommand", commandParam, daoProvider, viewProvider);
	}

	public AbstractInviteUserCommand(IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.InviteUserCommand", null, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.category.events.InviteUserOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		case hasAccess:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
