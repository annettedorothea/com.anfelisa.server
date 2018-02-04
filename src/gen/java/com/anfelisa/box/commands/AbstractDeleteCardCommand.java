package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.CardIdData;

public abstract class AbstractDeleteCardCommand extends Command<CardIdData> {

	protected static final String deleted = "deleted";

	public AbstractDeleteCardCommand(CardIdData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.DeleteCardCommand", commandParam, databaseHandle);
	}

	public AbstractDeleteCardCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.DeleteCardCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case deleted:
			new com.anfelisa.box.events.CardDeletedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, CardIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
