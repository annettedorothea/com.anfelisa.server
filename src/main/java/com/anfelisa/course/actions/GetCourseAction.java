package com.anfelisa.course.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseData;
import com.anfelisa.course.models.CourseDao;
import com.anfelisa.course.models.ICourseModel;

public class GetCourseAction extends AbstractGetCourseAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCourseAction.class);

	public GetCourseAction(CourseData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		ICourseModel course = CourseDao.selectByCourseId(this.getDatabaseHandle().getHandle(), this.actionData.getCourseId(), this.actionData.getSchema());
		this.actionData.setAuthor(course.getAuthor());
		this.actionData.setDescription(course.getDescription());
		this.actionData.setName(course.getName());
		this.actionData.setIsPublic(course.getIsPublic());
		this.actionData.setSequence(course.getSequence());
	}

}

/*       S.D.G.       */
