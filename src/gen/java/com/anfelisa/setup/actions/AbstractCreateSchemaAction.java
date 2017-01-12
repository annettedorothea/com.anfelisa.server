package com.anfelisa.setup.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.setup.data.SchemaCreationData;

import com.anfelisa.setup.commands.CreateSchemaCommand;

public abstract class AbstractCreateSchemaAction extends Action<SchemaCreationData> {

	public AbstractCreateSchemaAction(SchemaCreationData actionParam, DatabaseHandle databaseHandle) {
		super("CreateSchemaAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new CreateSchemaCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
