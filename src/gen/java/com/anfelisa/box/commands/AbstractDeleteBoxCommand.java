package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IDeleteBoxData;

public abstract class AbstractDeleteBoxCommand extends Command<IDeleteBoxData> {

	protected static final String ok = "ok";

	public AbstractDeleteBoxCommand(IDeleteBoxData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.DeleteBoxCommand", commandParam, daoProvider, viewProvider);
	}

	public AbstractDeleteBoxCommand(IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.commands.DeleteBoxCommand", null, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.box.events.DeleteBoxOkEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
