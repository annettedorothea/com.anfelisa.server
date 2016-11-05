package com.anfelisa.test.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.TestCreationData;

import com.anfelisa.test.commands.CreateTestCommand;

public abstract class AbstractCreateTestAction extends Action<TestCreationData> {

	public AbstractCreateTestAction(TestCreationData actionParam, DatabaseHandle databaseHandle) {
		super("CreateTestAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new CreateTestCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
