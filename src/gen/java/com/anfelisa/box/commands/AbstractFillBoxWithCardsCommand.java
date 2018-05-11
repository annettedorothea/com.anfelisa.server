package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.FillBoxData;

public abstract class AbstractFillBoxWithCardsCommand extends Command<FillBoxData> {

	protected static final String fillBoxWithCards = "fillBoxWithCards";

	public AbstractFillBoxWithCardsCommand(FillBoxData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.FillBoxWithCardsCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractFillBoxWithCardsCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.FillBoxWithCardsCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case fillBoxWithCards:
			new com.anfelisa.box.events.FillBoxWithCardsFillBoxWithCardsEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
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
