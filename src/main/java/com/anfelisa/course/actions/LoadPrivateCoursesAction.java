package com.anfelisa.course.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.data.MyCourseListData;
import com.anfelisa.course.models.CustomCourseDao;

public class LoadPrivateCoursesAction extends AbstractLoadPrivateCoursesAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateCoursesAction.class);

	public LoadPrivateCoursesAction(MyCourseListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		this.actionData.setMyCourseList(CustomCourseDao.selectMyCourses(this.getDatabaseHandle().getHandle(),
				this.getActionData().getSchema(), this.actionParam.getUsername()));
	}

}

/* S.D.G. */
