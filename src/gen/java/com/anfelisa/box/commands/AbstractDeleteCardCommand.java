package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DaoProvider;

import com.anfelisa.box.data.CardIdData;

public abstract class AbstractDeleteCardCommand extends Command<CardIdData> {


	public AbstractDeleteCardCommand(CardIdData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.box.commands.DeleteCardCommand", commandParam, databaseHandle, daoProvider);
	}

	public AbstractDeleteCardCommand(DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.box.commands.DeleteCardCommand", null, databaseHandle, daoProvider);
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
			this.commandData = mapper.readValue(json, CardIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
