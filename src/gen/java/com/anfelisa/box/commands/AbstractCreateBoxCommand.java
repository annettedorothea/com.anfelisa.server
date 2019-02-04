package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IBoxData;

public abstract class AbstractCreateBoxCommand extends Command<IBoxData> {

	protected static final String ok = "ok";

	public AbstractCreateBoxCommand(IBoxData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.CreateBoxCommand", commandParam, daoProvider, viewProvider);
	}

	public AbstractCreateBoxCommand(IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.CreateBoxCommand", null, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.box.events.CreateBoxOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
