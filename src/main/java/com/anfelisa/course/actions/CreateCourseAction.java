package com.anfelisa.course.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseCreationData;

public class CreateCourseAction extends AbstractCreateCourseAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateCourseAction.class);

	public CreateCourseAction(CourseCreationData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
	}

}

/*       S.D.G.       */
