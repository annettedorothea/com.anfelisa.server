package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.TestCreationData;

public abstract class AbstractCreateTestCommand extends Command<TestCreationData> {

	protected static final String created = "created";

	public AbstractCreateTestCommand(TestCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.CreateTestCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.test.events.TestCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */
