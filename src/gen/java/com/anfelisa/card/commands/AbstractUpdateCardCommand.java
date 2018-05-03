package com.anfelisa.card.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.card.data.CardUpdateData;

public abstract class AbstractUpdateCardCommand extends Command<CardUpdateData> {

	protected static final String ok = "ok";

	public AbstractUpdateCardCommand(CardUpdateData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.card.commands.UpdateCardCommand", commandParam, databaseHandle);
	}

	public AbstractUpdateCardCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.card.commands.UpdateCardCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.card.events.UpdateCardOkEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, CardUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
