package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.DeleteBoxData;

public abstract class AbstractDeleteBoxCommand extends Command<DeleteBoxData> {

	protected static final String deleted = "deleted";

	public AbstractDeleteBoxCommand(DeleteBoxData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.DeleteBoxCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case deleted:
			new com.anfelisa.box.events.BoxDeletedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */
