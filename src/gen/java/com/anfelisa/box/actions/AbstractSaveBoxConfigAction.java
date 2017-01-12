package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxConfigData;

import com.anfelisa.box.commands.SaveBoxConfigCommand;

public abstract class AbstractSaveBoxConfigAction extends Action<BoxConfigData> {

	public AbstractSaveBoxConfigAction(DBI jdbi) {
		super("SaveBoxConfigAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new SaveBoxConfigCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
