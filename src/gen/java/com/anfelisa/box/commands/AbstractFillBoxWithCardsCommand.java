package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.BoxIdListData;

public abstract class AbstractFillBoxWithCardsCommand extends Command<BoxIdListData> {

	protected static final String fillBoxWithCards = "fillBoxWithCards";

	public AbstractFillBoxWithCardsCommand(BoxIdListData commandParam, DatabaseHandle databaseHandle) {
		super("FillBoxWithCardsCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case fillBoxWithCards:
			new com.anfelisa.box.events.FillBoxWithCardsEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */