package com.anfelisa.result.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.result.data.ResultCreationData;

import com.anfelisa.result.commands.CreateResultCommand;

public abstract class AbstractCreateResultAction extends Action<ResultCreationData> {

	public AbstractCreateResultAction(ResultCreationData actionParam, DatabaseHandle databaseHandle) {
		super("CreateResultAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new CreateResultCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
