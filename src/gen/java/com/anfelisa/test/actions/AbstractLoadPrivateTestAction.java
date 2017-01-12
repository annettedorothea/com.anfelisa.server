package com.anfelisa.test.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.MyTestData;


public abstract class AbstractLoadPrivateTestAction extends Action<MyTestData> {

	public AbstractLoadPrivateTestAction(DBI jdbi) {
		super("LoadPrivateTestAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
