package com.anfelisa.setup.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.setup.data.SetupData;

public class SetupAnfelisaAction extends AbstractSetupAnfelisaAction {

	static final Logger LOG = LoggerFactory.getLogger(SetupAnfelisaAction.class);

	public SetupAnfelisaAction(SetupData actionParam, DatabaseHandle databaseHandle) {
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
