package com.anfelisa.lesson.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.models.CourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.data.LessonListData;
import com.anfelisa.lesson.models.CustomLessonDao;

public class LoadPublicLessonsAction extends AbstractLoadPublicLessonsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicLessonsAction.class);

	public LoadPublicLessonsAction(LessonListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		ICourseModel course = CourseDao.selectById(this.getDatabaseHandle().getHandle(), this.actionData.getCourseId(), this.getActionData().getSchema());
		this.actionData.setCourseDescription(course.getDescription());
		this.actionData.setCourseAuthor(course.getAuthor());
		this.actionData.setIsPublic(course.getIsPublic());
		this.actionData.setCourseName(course.getName());
		this.actionData.setLessonList(CustomLessonDao.selectPublicLessons(this.getDatabaseHandle().getHandle(), this.getActionData().getSchema(), this.actionParam.getCourseId()));
	}

}

/*       S.D.G.       */
