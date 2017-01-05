package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.CardIdData;

public abstract class AbstractDeleteCardCommand extends Command<CardIdData> {

	protected static final String deleted = "deleted";

	public AbstractDeleteCardCommand(CardIdData commandParam, DatabaseHandle databaseHandle) {
		super("DeleteCardCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case deleted:
			new com.anfelisa.box.events.CardDeletedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
