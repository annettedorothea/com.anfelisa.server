package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.IRevokeUserData;

public abstract class AbstractRevokeUserAccessCommand extends Command<IRevokeUserData> {

	protected static final String ok = "ok";
	protected static final String hasNoAccess = "hasNoAccess";

	public AbstractRevokeUserAccessCommand(IRevokeUserData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.category.commands.RevokeUserAccessCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.category.events.RevokeUserAccessOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		case hasNoAccess:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
