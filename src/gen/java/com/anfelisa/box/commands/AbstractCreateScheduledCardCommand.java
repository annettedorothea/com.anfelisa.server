package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.ScheduledCardData;

public abstract class AbstractCreateScheduledCardCommand extends Command<ScheduledCardData> {

	protected static final String created = "created";

	public AbstractCreateScheduledCardCommand(ScheduledCardData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.CreateScheduledCardCommand", commandParam, databaseHandle);
	}

	public AbstractCreateScheduledCardCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.CreateScheduledCardCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case created:
			new com.anfelisa.box.events.CreateScheduledCardCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, ScheduledCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
