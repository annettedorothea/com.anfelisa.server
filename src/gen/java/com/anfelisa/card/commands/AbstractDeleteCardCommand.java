package com.anfelisa.card.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.card.data.ICardDeleteData;

public abstract class AbstractDeleteCardCommand extends Command<ICardDeleteData> {

	protected static final String ok = "ok";

	public AbstractDeleteCardCommand(ICardDeleteData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.commands.DeleteCardCommand", commandParam, daoProvider, viewProvider);
	}

	public AbstractDeleteCardCommand(IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.commands.DeleteCardCommand", null, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.card.events.DeleteCardOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
