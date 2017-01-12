package com.anfelisa.box.actions_;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.actions.AbstractCreateCardOfBoxAction;
import com.anfelisa.box.data.CardOfBoxCreationData;

public class CreateCardOfBoxAction extends AbstractCreateCardOfBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardOfBoxAction.class);

	public CreateCardOfBoxAction(CardOfBoxCreationData actionParam, DatabaseHandle databaseHandle) {
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
