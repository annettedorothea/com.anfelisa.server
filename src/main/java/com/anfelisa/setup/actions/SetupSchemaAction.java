package com.anfelisa.setup.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.setup.data.SetupSchemaData;

public class SetupSchemaAction extends AbstractSetupSchemaAction {

	static final Logger LOG = LoggerFactory.getLogger(SetupSchemaAction.class);

	public SetupSchemaAction(SetupSchemaData actionParam, DatabaseHandle databaseHandle) {
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
