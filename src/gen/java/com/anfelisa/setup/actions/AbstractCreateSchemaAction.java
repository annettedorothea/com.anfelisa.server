package com.anfelisa.setup.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.setup.data.SchemaCreationData;

import com.anfelisa.setup.commands.CreateSchemaCommand;

public abstract class AbstractCreateSchemaAction extends Action<SchemaCreationData> {

	public AbstractCreateSchemaAction(DBI jdbi) {
		super("CreateSchemaAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new CreateSchemaCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
