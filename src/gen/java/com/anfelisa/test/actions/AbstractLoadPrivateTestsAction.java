package com.anfelisa.test.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.TestListData;


public abstract class AbstractLoadPrivateTestsAction extends Action<TestListData> {

	public AbstractLoadPrivateTestsAction(TestListData actionParam, DatabaseHandle databaseHandle) {
		super("LoadPrivateTestsAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
