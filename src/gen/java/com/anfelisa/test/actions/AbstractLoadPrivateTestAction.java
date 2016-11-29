package com.anfelisa.test.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.MyTestData;


public abstract class AbstractLoadPrivateTestAction extends Action<MyTestData> {

	public AbstractLoadPrivateTestAction(MyTestData actionParam, DatabaseHandle databaseHandle) {
		super("LoadPrivateTestAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
