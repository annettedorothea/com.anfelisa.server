package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.CardCreationData;

public abstract class AbstractImportCardCommand extends Command<CardCreationData> {

	protected static final String imported = "imported";
	protected static final String alreadyExists = "alreadyExists";

	public AbstractImportCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.ImportCardCommand", commandParam, databaseHandle);
	}

	public AbstractImportCardCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.ImportCardCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case imported:
			new com.anfelisa.box.events.ImportCardImportedEvent(this.commandData, databaseHandle).publish();
			break;
		case alreadyExists:
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
