package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.TestIdData;

public abstract class AbstractDeleteTestCommand extends Command<TestIdData> {

	protected static final String deleted = "deleted";

	public AbstractDeleteTestCommand(TestIdData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.DeleteTestCommand", commandParam, databaseHandle);
	}

	public AbstractDeleteTestCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.DeleteTestCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case deleted:
			new com.anfelisa.test.events.TestDeletedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, TestIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
