package com.anfelisa.box.actions_;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.actions.AbstractUpdateBoxAction;
import com.anfelisa.box.data.BoxCreationData;

public class UpdateBoxAction extends AbstractUpdateBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(UpdateBoxAction.class);

	public UpdateBoxAction(BoxCreationData actionParam, DatabaseHandle databaseHandle) {
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
