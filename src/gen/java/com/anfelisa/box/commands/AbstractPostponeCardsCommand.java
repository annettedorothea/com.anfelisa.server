package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.PostponeCardsData;

public abstract class AbstractPostponeCardsCommand extends Command<PostponeCardsData> {

	protected static final String ok = "ok";
	protected static final String noDelay = "noDelay";

	public AbstractPostponeCardsCommand(PostponeCardsData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
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
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, PostponeCardsData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
