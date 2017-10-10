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

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.box.events.ScheduledCardCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */
