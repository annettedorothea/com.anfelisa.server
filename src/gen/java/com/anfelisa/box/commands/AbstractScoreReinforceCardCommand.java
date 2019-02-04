package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IScoreReinforceCardData;

public abstract class AbstractScoreReinforceCardCommand extends Command<IScoreReinforceCardData> {

	protected static final String remove = "remove";
	protected static final String keep = "keep";

	public AbstractScoreReinforceCardCommand(IScoreReinforceCardData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.ScoreReinforceCardCommand", commandParam, daoProvider, viewProvider);
	}

	public AbstractScoreReinforceCardCommand(IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.ScoreReinforceCardCommand", null, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case remove:
			new com.anfelisa.box.events.ScoreReinforceCardRemoveEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		case keep:
			new com.anfelisa.box.events.ScoreReinforceCardKeepEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
