package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.IRevokeUserData;

public abstract class AbstractRevokeUserAccessCommand extends Command<IRevokeUserData> {

	protected static final String ok = "ok";
	protected static final String hasNoAccess = "hasNoAccess";

	public AbstractRevokeUserAccessCommand(IRevokeUserData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.RevokeUserAccessCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractRevokeUserAccessCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.RevokeUserAccessCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.category.events.RevokeUserAccessOkEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		case hasNoAccess:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
