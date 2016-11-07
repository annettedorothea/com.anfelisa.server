package com.anfelisa.course.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseListData;
import com.anfelisa.course.models.CustomCourseDao;

public class LoadPublicCoursesAction extends AbstractLoadPublicCoursesAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicCoursesAction.class);

	public LoadPublicCoursesAction(CourseListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		this.actionData.setCourseList(CustomCourseDao.selectPublic(this.getDatabaseHandle().getHandle(), this.getActionData().getSchema()));
	}

}

/*       S.D.G.       */
