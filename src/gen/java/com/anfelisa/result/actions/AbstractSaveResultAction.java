package com.anfelisa.result.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.result.data.ResultSaveData;

import com.anfelisa.result.commands.SaveResultCommand;

public abstract class AbstractSaveResultAction extends Action<ResultSaveData> {

	public AbstractSaveResultAction(DBI jdbi) {
		super("SaveResultAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new SaveResultCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
