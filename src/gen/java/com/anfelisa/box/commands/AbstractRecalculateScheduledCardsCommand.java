package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.RecalculateScheduledCardsData;

public abstract class AbstractRecalculateScheduledCardsCommand extends Command<RecalculateScheduledCardsData> {

	protected static final String ok = "ok";

	public AbstractRecalculateScheduledCardsCommand(RecalculateScheduledCardsData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.RecalculateScheduledCardsCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case ok:
			new com.anfelisa.box.events.RecalculateScheduledCardsEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */
