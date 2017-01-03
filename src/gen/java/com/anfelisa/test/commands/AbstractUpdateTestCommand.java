package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.TestCreationData;

public abstract class AbstractUpdateTestCommand extends Command<TestCreationData> {

	protected static final String updated = "updated";

	public AbstractUpdateTestCommand(TestCreationData commandParam, DatabaseHandle databaseHandle) {
		super("UpdateTestCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case updated:
			new com.anfelisa.test.events.TestUpdatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
