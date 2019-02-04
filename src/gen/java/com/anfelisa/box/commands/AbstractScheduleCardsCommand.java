package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IScheduledCardsData;

public abstract class AbstractScheduleCardsCommand extends Command<IScheduledCardsData> {

	protected static final String ok = "ok";
	protected static final String nullOrEmpty = "nullOrEmpty";

	public AbstractScheduleCardsCommand(IScheduledCardsData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.ScheduleCardsCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.box.events.ScheduleCardsOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		case nullOrEmpty:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
