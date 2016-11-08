package com.anfelisa.test.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.TestListData;


public abstract class AbstractLoadPublicTestsAction extends Action<TestListData> {

	public AbstractLoadPublicTestsAction(TestListData actionParam, DatabaseHandle databaseHandle) {
		super("LoadPublicTestsAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
