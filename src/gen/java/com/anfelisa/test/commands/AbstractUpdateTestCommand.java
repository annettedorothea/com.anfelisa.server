package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.TestCreationData;

public abstract class AbstractUpdateTestCommand extends Command<TestCreationData> {

	protected static final String updated = "updated";

	public AbstractUpdateTestCommand(TestCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.UpdateTestCommand", commandParam, databaseHandle);
	}

	public AbstractUpdateTestCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.UpdateTestCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case updated:
			new com.anfelisa.test.events.TestUpdatedEvent(this.commandData, databaseHandle).publish();
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
