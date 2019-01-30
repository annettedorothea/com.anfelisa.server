package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IPostponeCardsData;

public abstract class AbstractPostponeCardsCommand extends Command<IPostponeCardsData> {

	protected static final String ok = "ok";
	protected static final String noDelay = "noDelay";

	public AbstractPostponeCardsCommand(IPostponeCardsData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.PostponeCardsCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractPostponeCardsCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.PostponeCardsCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.box.events.PostponeCardsOkEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		case noDelay:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
