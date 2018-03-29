package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.ScoreCardData;

public abstract class AbstractScoreCardCommand extends Command<ScoreCardData> {

	protected static final String scored = "scored";

	public AbstractScoreCardCommand(ScoreCardData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.ScoreCardCommand", commandParam, databaseHandle);
	}

	public AbstractScoreCardCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.ScoreCardCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case scored:
			new com.anfelisa.box.events.ScoreCardScoredEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, ScoreCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
