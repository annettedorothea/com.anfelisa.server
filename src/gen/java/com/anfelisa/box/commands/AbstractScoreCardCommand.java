package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IScoreCardData;

public abstract class AbstractScoreCardCommand extends Command<IScoreCardData> {

	protected static final String score = "score";
	protected static final String scoreAndReinforce = "scoreAndReinforce";

	public AbstractScoreCardCommand(IScoreCardData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.ScoreCardCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case score:
			new com.anfelisa.box.events.ScoreCardScoreEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		case scoreAndReinforce:
			new com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
