package com.anfelisa.setup.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.setup.data.SchemaCreationData;

public abstract class AbstractCreateSchemaCommand extends Command<SchemaCreationData> {

	protected static final String setup = "setup";

	public AbstractCreateSchemaCommand(SchemaCreationData commandParam, DatabaseHandle databaseHandle) {
		super("CreateSchemaCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case setup:
			new com.anfelisa.setup.events.CreateSchemaEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
