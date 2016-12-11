package com.anfelisa.course.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.data.StudentToCourseAdditionData;

public class AddStudentToCourseAction extends AbstractAddStudentToCourseAction {

	static final Logger LOG = LoggerFactory.getLogger(AddStudentToCourseAction.class);

	public AddStudentToCourseAction(StudentToCourseAdditionData actionParam, DatabaseHandle databaseHandle) {
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
