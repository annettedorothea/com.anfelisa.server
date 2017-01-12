package com.anfelisa.setup.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.setup.data.SetupSchemaData;

import com.anfelisa.setup.commands.SetupSchemaCommand;

public abstract class AbstractSetupSchemaAction extends Action<SetupSchemaData> {

	public AbstractSetupSchemaAction(DBI jdbi) {
		super("SetupSchemaAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new SetupSchemaCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
