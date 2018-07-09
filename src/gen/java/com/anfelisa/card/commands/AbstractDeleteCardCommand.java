package com.anfelisa.card.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.card.data.CardDeleteData;

public abstract class AbstractDeleteCardCommand extends Command<CardDeleteData> {

	protected static final String ok = "ok";

	public AbstractDeleteCardCommand(CardDeleteData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.commands.DeleteCardCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractDeleteCardCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.commands.DeleteCardCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.card.events.DeleteCardOkEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, CardDeleteData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
