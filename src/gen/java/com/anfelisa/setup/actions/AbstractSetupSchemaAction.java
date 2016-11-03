package com.anfelisa.setup.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.setup.data.SetupSchemaData;

import com.anfelisa.setup.commands.SetupSchemaCommand;

public abstract class AbstractSetupSchemaAction extends Action<SetupSchemaData> {

	public AbstractSetupSchemaAction(SetupSchemaData actionParam, DatabaseHandle databaseHandle) {
		super("SetupSchemaAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new SetupSchemaCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
