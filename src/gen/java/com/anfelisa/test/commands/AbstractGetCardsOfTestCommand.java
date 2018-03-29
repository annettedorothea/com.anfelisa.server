package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.CardContentHashListData;

public abstract class AbstractGetCardsOfTestCommand extends Command<CardContentHashListData> {


	public AbstractGetCardsOfTestCommand(CardContentHashListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.GetCardsOfTestCommand", commandParam, databaseHandle);
	}

	public AbstractGetCardsOfTestCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.GetCardsOfTestCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, CardContentHashListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
