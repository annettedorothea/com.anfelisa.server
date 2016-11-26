package com.anfelisa.setup.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.setup.data.SetupData;

public abstract class AbstractSetupAnfelisaCommand extends Command<SetupData> {

	protected static final String setup = "setup";

	public AbstractSetupAnfelisaCommand(SetupData commandParam, DatabaseHandle databaseHandle) {
		super("SetupAnfelisaCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case setup:
			new com.anfelisa.setup.events.SetupAnfelisaEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
