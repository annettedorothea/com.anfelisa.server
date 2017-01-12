package com.anfelisa.result.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.result.data.ResultCreationData;

import com.anfelisa.result.commands.CreateResultCommand;

public abstract class AbstractCreateResultAction extends Action<ResultCreationData> {

	public AbstractCreateResultAction(DBI jdbi) {
		super("CreateResultAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new CreateResultCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
