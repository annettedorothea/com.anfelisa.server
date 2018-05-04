package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DaoProvider;

import com.anfelisa.box.data.FillBoxData;

public abstract class AbstractFillBoxWithCardsCommand extends Command<FillBoxData> {

	protected static final String fillBoxWithCards = "fillBoxWithCards";

	public AbstractFillBoxWithCardsCommand(FillBoxData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.box.commands.FillBoxWithCardsCommand", commandParam, databaseHandle, daoProvider);
	}

	public AbstractFillBoxWithCardsCommand(DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.box.commands.FillBoxWithCardsCommand", null, databaseHandle, daoProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case fillBoxWithCards:
			new com.anfelisa.box.events.FillBoxWithCardsFillBoxWithCardsEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, FillBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
