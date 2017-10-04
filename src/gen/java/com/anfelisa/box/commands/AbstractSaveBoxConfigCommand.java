package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.BoxConfigData;

public abstract class AbstractSaveBoxConfigCommand extends Command<BoxConfigData> {

	protected static final String saved = "saved";

	public AbstractSaveBoxConfigCommand(BoxConfigData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.SaveBoxConfigCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case saved:
			new com.anfelisa.box.events.BoxConfigSavedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */
