package com.anfelisa.result.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DatabaseService;

import com.anfelisa.result.data.ResultCreationData;

public abstract class AbstractCreateResultCommand extends Command<ResultCreationData> {

	protected static final String created = "created";

	public AbstractCreateResultCommand(ResultCreationData commandParam, DatabaseHandle databaseHandle) {
		super("CreateResultCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.result.events.ResultCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
