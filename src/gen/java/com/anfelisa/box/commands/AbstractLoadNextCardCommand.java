package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.CardData;

public abstract class AbstractLoadNextCardCommand extends Command<CardData> {


	public AbstractLoadNextCardCommand(CardData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.LoadNextCardCommand", commandParam, databaseHandle);
	}

	public AbstractLoadNextCardCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.LoadNextCardCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, CardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
