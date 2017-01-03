package com.anfelisa.test.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.TestCreationData;

import com.anfelisa.test.commands.UpdateTestCommand;

public abstract class AbstractUpdateTestAction extends Action<TestCreationData> {

	public AbstractUpdateTestAction(TestCreationData actionParam, DatabaseHandle databaseHandle) {
		super("UpdateTestAction", HttpMethod.PUT, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateTestCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
