package com.anfelisa.test.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestData;

public class LoadPrivateTestAction extends AbstractLoadPrivateTestAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateTestAction.class);

	public LoadPrivateTestAction(TestData actionParam, DatabaseHandle databaseHandle) {
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
