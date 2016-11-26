package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.CardOfBoxCreationData;

public abstract class AbstractCreateCardOfBoxCommand extends Command<CardOfBoxCreationData> {

	protected static final String created = "created";

	public AbstractCreateCardOfBoxCommand(CardOfBoxCreationData commandParam, DatabaseHandle databaseHandle) {
		super("CreateCardOfBoxCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.box.events.CardOfBoxCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
