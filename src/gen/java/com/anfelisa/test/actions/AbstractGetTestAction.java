package com.anfelisa.test.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.TestCreationData;


public abstract class AbstractGetTestAction extends Action<TestCreationData> {

	public AbstractGetTestAction(TestCreationData actionParam, DatabaseHandle databaseHandle) {
		super("GetTestAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
