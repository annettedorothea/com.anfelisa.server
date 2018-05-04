package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DaoProvider;

import com.anfelisa.box.data.CardCreationData;

public abstract class AbstractImportCardCommand extends Command<CardCreationData> {

	protected static final String alreadyExists = "alreadyExists";

	public AbstractImportCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.box.commands.ImportCardCommand", commandParam, databaseHandle, daoProvider);
	}

	public AbstractImportCardCommand(DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.box.commands.ImportCardCommand", null, databaseHandle, daoProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
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
