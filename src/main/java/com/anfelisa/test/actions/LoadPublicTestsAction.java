package com.anfelisa.test.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.models.ILessonModel;
import com.anfelisa.lesson.models.LessonDao;
import com.anfelisa.test.data.TestListData;
import com.anfelisa.test.models.CustomTestDao;

public class LoadPublicTestsAction extends AbstractLoadPublicTestsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicTestsAction.class);

	public LoadPublicTestsAction(TestListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		ILessonModel lesson = LessonDao.selectByLessonId(this.getDatabaseHandle().getHandle(), this.actionData.getLessonId(),
				this.getActionData().getSchema());
		this.actionData.setLessonDescription(lesson.getDescription());
		this.actionData.setLessonAuthor(lesson.getAuthor());
		this.actionData.setLessonName(lesson.getName());
		ICourseModel course = CustomCourseDao.selectByLessonId(this.getDatabaseHandle().getHandle(),
				this.actionData.getLessonId(), this.getActionData().getSchema());
		this.actionData.setCourseAuthor(course.getAuthor());
		this.actionData.setCourseDescription(course.getDescription());
		this.actionData.setCourseName(course.getName());
		this.actionData.setCourseId(course.getCourseId());
		this.actionData.setTestList(CustomTestDao.selectTests(this.getDatabaseHandle().getHandle(),
				this.getActionData().getSchema(), this.actionParam.getLessonId()));
	}

}

/* S.D.G. */
