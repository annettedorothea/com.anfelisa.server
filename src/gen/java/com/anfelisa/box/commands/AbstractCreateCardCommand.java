package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DaoProvider;

import com.anfelisa.box.data.CardCreationData;

public abstract class AbstractCreateCardCommand extends Command<CardCreationData> {


	public AbstractCreateCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.box.commands.CreateCardCommand", commandParam, databaseHandle, daoProvider);
	}

	public AbstractCreateCardCommand(DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.box.commands.CreateCardCommand", null, databaseHandle, daoProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
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
