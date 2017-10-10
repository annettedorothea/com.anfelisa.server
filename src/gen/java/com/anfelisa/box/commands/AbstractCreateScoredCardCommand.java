package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.ScoredCardData;

public abstract class AbstractCreateScoredCardCommand extends Command<ScoredCardData> {

	protected static final String created = "created";

	public AbstractCreateScoredCardCommand(ScoredCardData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.CreateScoredCardCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.box.events.ScoredCardCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */
