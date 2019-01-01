package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.ScoreCardData;

public abstract class AbstractScoreCardCommand extends Command<ScoreCardData> {

	protected static final String score = "score";
	protected static final String scoreAndReinforce = "scoreAndReinforce";

	public AbstractScoreCardCommand(ScoreCardData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.ScoreCardCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractScoreCardCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.ScoreCardCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case score:
			new com.anfelisa.box.events.ScoreCardScoreEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		case scoreAndReinforce:
			new com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
