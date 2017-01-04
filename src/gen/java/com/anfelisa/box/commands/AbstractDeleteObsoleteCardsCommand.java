package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.ContentHashesOfCreatedCardsData;

public abstract class AbstractDeleteObsoleteCardsCommand extends Command<ContentHashesOfCreatedCardsData> {

	protected static final String deleted = "deleted";

	public AbstractDeleteObsoleteCardsCommand(ContentHashesOfCreatedCardsData commandParam, DatabaseHandle databaseHandle) {
		super("DeleteObsoleteCardsCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case deleted:
			new com.anfelisa.box.events.DeleteObsoleteCardsEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
