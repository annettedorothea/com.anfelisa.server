package com.anfelisa.setup.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.setup.data.SetupSchemaData;

public abstract class AbstractSetupSchemaCommand extends Command<SetupSchemaData> {

	protected static final String setup = "setup";

	public AbstractSetupSchemaCommand(SetupSchemaData commandParam, DatabaseHandle databaseHandle) {
		super("SetupSchemaCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case setup:
			new com.anfelisa.setup.events.SetupSchemaEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
	
	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}
}

/*       S.D.G.       */
