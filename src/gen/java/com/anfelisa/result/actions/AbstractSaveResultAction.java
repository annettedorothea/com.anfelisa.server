package com.anfelisa.result.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.result.data.ResultSaveData;

import com.anfelisa.result.commands.SaveResultCommand;

public abstract class AbstractSaveResultAction extends Action<ResultSaveData> {

	public AbstractSaveResultAction(ResultSaveData actionParam, DatabaseHandle databaseHandle) {
		super("SaveResultAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new SaveResultCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
