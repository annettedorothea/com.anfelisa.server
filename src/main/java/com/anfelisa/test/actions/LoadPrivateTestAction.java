package com.anfelisa.test.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.models.CustomLessonDao;
import com.anfelisa.lesson.models.ILessonModel;
import com.anfelisa.test.data.MyTestData;
import com.anfelisa.test.models.CustomTestDao;
import com.anfelisa.test.models.ITestModel;
import com.anfelisa.test.models.TestDao;

public class LoadPrivateTestAction extends AbstractLoadPrivateTestAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateTestAction.class);

	public LoadPrivateTestAction(MyTestData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system
		// time)
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		ILessonModel lesson = CustomLessonDao.selectByTestId(this.getDatabaseHandle().getHandle(),
				this.actionData.getTestId(), this.getActionData().getSchema());
		this.actionData.setLessonDescription(lesson.getDescription());
		this.actionData.setLessonAuthor(lesson.getAuthor());
		this.actionData.setLessonName(lesson.getName());
		this.actionData.setLessonId(lesson.getLessonId());
		ICourseModel course = CustomCourseDao.selectByLessonId(this.getDatabaseHandle().getHandle(),
				lesson.getLessonId(), this.getActionData().getSchema());
		this.actionData.setCourseAuthor(course.getAuthor());
		this.actionData.setCourseDescription(course.getDescription());
		this.actionData.setCourseName(course.getName());
		this.actionData.setCourseId(course.getCourseId());
		ITestModel test = TestDao.selectByTestId(this.getDatabaseHandle().getHandle(), this.actionParam.getTestId(),
				this.getActionData().getSchema());
		this.actionData.setAuthor(test.getAuthor());
		this.actionData.setHtml(test.getHtml());
		this.actionData.setName(test.getName());
		this.actionData.setMyTestList(CustomTestDao.selectMyTests(this.getDatabaseHandle().getHandle(),
				this.getActionData().getSchema(), this.actionParam.getLessonId(), this.actionParam.getUsername()));
	}

}

/* S.D.G. */
