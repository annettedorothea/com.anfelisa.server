package com.anfelisa.test.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestListData;

public class LoadPrivateTestsAction extends AbstractLoadPrivateTestsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateTestsAction.class);

	public LoadPrivateTestsAction(TestListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		// init actionData
		this.actionData = this.actionParam;
	}

}

/*       S.D.G.       */
