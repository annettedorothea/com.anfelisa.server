package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.ScheduledCardsData;

public abstract class AbstractScheduleCardsCommand extends Command<ScheduledCardsData> {

	protected static final String ok = "ok";
	protected static final String nullOrEmpty = "nullOrEmpty";

	public AbstractScheduleCardsCommand(ScheduledCardsData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.ScheduleCardsCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractScheduleCardsCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.ScheduleCardsCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.box.events.ScheduleCardsOkEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		case nullOrEmpty:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
