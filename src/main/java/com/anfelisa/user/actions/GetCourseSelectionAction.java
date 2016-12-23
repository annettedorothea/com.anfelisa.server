package com.anfelisa.user.actions;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.CourseSelectionData;

public class GetCourseSelectionAction extends AbstractGetCourseSelectionAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCourseSelectionAction.class);

	public GetCourseSelectionAction(CourseSelectionData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		List<ICourseModel> courses = CustomCourseDao.selectCourseSelection(this.getDatabaseHandle().getHandle(), this.actionData.getSchema(), this.actionData.getUsername());
		this.actionData.setCourseList(courses);
	}

}

/*       S.D.G.       */
