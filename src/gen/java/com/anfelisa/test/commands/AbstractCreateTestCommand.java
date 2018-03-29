package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.TestCreationData;

public abstract class AbstractCreateTestCommand extends Command<TestCreationData> {

	protected static final String created = "created";

	public AbstractCreateTestCommand(TestCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.CreateTestCommand", commandParam, databaseHandle);
	}

	public AbstractCreateTestCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.CreateTestCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case created:
			new com.anfelisa.test.events.CreateTestCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, TestCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
