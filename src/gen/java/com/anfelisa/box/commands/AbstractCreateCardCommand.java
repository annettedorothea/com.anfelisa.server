package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.CardCreationData;

public abstract class AbstractCreateCardCommand extends Command<CardCreationData> {

	protected static final String created = "created";

	public AbstractCreateCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.CreateCardCommand", commandParam, databaseHandle);
	}

	public AbstractCreateCardCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.CreateCardCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case created:
			new com.anfelisa.box.events.CreateCardCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, CardCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
