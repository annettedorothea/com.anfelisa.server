package com.anfelisa.test.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.TestCreationData;

import com.anfelisa.test.commands.CreateTestCommand;

public abstract class AbstractCreateTestAction extends Action<TestCreationData> {

	public AbstractCreateTestAction(DBI jdbi) {
		super("CreateTestAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new CreateTestCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
