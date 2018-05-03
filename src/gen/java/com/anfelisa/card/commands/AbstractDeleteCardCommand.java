package com.anfelisa.card.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.card.data.CardDeleteData;

public abstract class AbstractDeleteCardCommand extends Command<CardDeleteData> {

	protected static final String ok = "ok";

	public AbstractDeleteCardCommand(CardDeleteData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.card.commands.DeleteCardCommand", commandParam, databaseHandle);
	}

	public AbstractDeleteCardCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.card.commands.DeleteCardCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.card.events.DeleteCardOkEvent(this.commandData, databaseHandle).publish();
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
