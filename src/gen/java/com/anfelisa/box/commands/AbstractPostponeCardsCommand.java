package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IPostponeCardsData;

public abstract class AbstractPostponeCardsCommand extends Command<IPostponeCardsData> {

	protected static final String ok = "ok";
	protected static final String noDelay = "noDelay";

	public AbstractPostponeCardsCommand(IPostponeCardsData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.PostponeCardsCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.box.events.PostponeCardsOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		case noDelay:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
