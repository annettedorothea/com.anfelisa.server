package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.RecalculateScheduledCardsData;

public abstract class AbstractRecalculateScheduledCardsCommand extends Command<RecalculateScheduledCardsData> {

	protected static final String ok = "ok";

	public AbstractRecalculateScheduledCardsCommand(RecalculateScheduledCardsData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.RecalculateScheduledCardsCommand", commandParam, databaseHandle);
	}

	public AbstractRecalculateScheduledCardsCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.RecalculateScheduledCardsCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.box.events.RecalculateScheduledCardsOkEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, RecalculateScheduledCardsData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
