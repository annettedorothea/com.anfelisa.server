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

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case scored:
			new com.anfelisa.box.events.CardScoredEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */
