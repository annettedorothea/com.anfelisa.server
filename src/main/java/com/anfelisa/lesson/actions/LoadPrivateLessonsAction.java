package com.anfelisa.lesson.actions;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.models.CourseDao;
import com.anfelisa.course.models.ICourseModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.MyLessonListData;
import com.anfelisa.lesson.models.CustomLessonDao;

public class LoadPrivateLessonsAction extends AbstractLoadPrivateLessonsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateLessonsAction.class);

	public LoadPrivateLessonsAction(MyLessonListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		ICourseModel course = CourseDao.selectByCourseId(this.getDatabaseHandle().getHandle(), this.actionData.getCourseId(),
				this.getActionData().getSchema());
		this.actionData.setCourseDescription(course.getDescription());
		this.actionData.setCourseAuthor(course.getAuthor());
		this.actionData.setIsPublic(course.getIsPublic());
		this.actionData.setCourseName(course.getName());
		this.actionData.setMyLessonList(CustomLessonDao.selectMyLessons(this.getDatabaseHandle().getHandle(),
				this.getActionData().getSchema(), this.actionParam.getCourseId(), this.actionParam.getUsername()));
	}

}

/* S.D.G. */
