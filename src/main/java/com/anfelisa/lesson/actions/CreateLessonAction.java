package com.anfelisa.lesson.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.lesson.data.LessonCreationData;

public class CreateLessonAction extends AbstractCreateLessonAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateLessonAction.class);

	public CreateLessonAction(LessonCreationData actionParam, DatabaseHandle databaseHandle) {
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
