package com.anfelisa.box.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxToCourseAdditionData;

public class AddCourseToBoxAction extends AbstractAddCourseToBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(AddCourseToBoxAction.class);

	public AddCourseToBoxAction(BoxToCourseAdditionData actionParam, DatabaseHandle databaseHandle) {
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
