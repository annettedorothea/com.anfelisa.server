package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.ScheduleCardData;

public abstract class AbstractScheduleCardCommand extends Command<ScheduleCardData> {

	protected static final String ok = "ok";

	public AbstractScheduleCardCommand(ScheduleCardData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.ScheduleCardCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractScheduleCardCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.ScheduleCardCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.box.events.ScheduleCardOkEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, ScheduleCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
