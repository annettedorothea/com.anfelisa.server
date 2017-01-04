package com.anfelisa.box.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.CardCreationData;

public class CreateCardAction extends AbstractCreateCardAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardAction.class);

	public CreateCardAction(CardCreationData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system
		// time)
	}

	@Override
	protected void applyAction() {
		// init actionData
		this.actionData = this.actionParam;
	}

}

/* S.D.G. */
