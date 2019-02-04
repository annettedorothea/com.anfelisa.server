package com.anfelisa.card.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.card.data.ICardCreationData;

public abstract class AbstractCreateCardCommand extends Command<ICardCreationData> {

	protected static final String ok = "ok";

	public AbstractCreateCardCommand(ICardCreationData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.commands.CreateCardCommand", commandParam, daoProvider, viewProvider);
	}

	public AbstractCreateCardCommand(IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.commands.CreateCardCommand", null, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.card.events.CreateCardOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
