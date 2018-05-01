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

	public AbstractCreateScoredCardCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.CreateScoredCardCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case created:
			new com.anfelisa.box.events.CreateScoredCardCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, ScoredCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
