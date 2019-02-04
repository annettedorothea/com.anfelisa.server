package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IChangeUserRoleData;

public abstract class AbstractChangeUserRoleCommand extends Command<IChangeUserRoleData> {

	protected static final String ok = "ok";

	public AbstractChangeUserRoleCommand(IChangeUserRoleData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.commands.ChangeUserRoleCommand", commandParam, daoProvider, viewProvider);
	}

	public AbstractChangeUserRoleCommand(IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.commands.ChangeUserRoleCommand", null, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.user.events.ChangeUserRoleOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
