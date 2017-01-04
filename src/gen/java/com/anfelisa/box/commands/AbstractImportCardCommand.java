package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.CardCreationData;

public abstract class AbstractImportCardCommand extends Command<CardCreationData> {

	protected static final String imported = "imported";
	protected static final String alreadyExists = "alreadyExists";

	public AbstractImportCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle) {
		super("ImportCardCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case imported:
			new com.anfelisa.box.events.CardImportedEvent(this.commandData, databaseHandle).publish();
			break;
		case alreadyExists:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
