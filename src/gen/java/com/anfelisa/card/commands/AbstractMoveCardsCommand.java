package com.anfelisa.card.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.card.data.ICardIdListData;

public abstract class AbstractMoveCardsCommand extends Command<ICardIdListData> {

	protected static final String ok = "ok";

	public AbstractMoveCardsCommand(ICardIdListData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.commands.MoveCardsCommand", commandParam, daoProvider, viewProvider);
	}

	public AbstractMoveCardsCommand(IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.commands.MoveCardsCommand", null, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.card.events.MoveCardsOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
