package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.ScoreReinforceCardData;

public abstract class AbstractScoreReinforceCardCommand extends Command<ScoreReinforceCardData> {

	protected static final String remove = "remove";
	protected static final String keep = "keep";

	public AbstractScoreReinforceCardCommand(ScoreReinforceCardData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.ScoreReinforceCardCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractScoreReinforceCardCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.ScoreReinforceCardCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case remove:
			new com.anfelisa.box.events.ScoreReinforceCardRemoveEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		case keep:
			new com.anfelisa.box.events.ScoreReinforceCardKeepEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, ScoreReinforceCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
