package com.anfelisa.test.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.models.CustomLessonDao;
import com.anfelisa.lesson.models.ILessonModel;
import com.anfelisa.test.data.TestData;
import com.anfelisa.test.models.CustomTestDao;
import com.anfelisa.test.models.ITestModel;
import com.anfelisa.test.models.TestDao;

public class LoadPublicTestAction extends AbstractLoadPublicTestAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicTestAction.class);

	public LoadPublicTestAction(TestData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		ILessonModel lesson = CustomLessonDao.selectByTestId(this.getDatabaseHandle().getHandle(),
				this.actionData.getTestId(), this.getActionData().getSchema());
		this.actionData.setLessonDescription(lesson.getDescription());
		this.actionData.setLessonAuthor(lesson.getAuthor());
		this.actionData.setLessonName(lesson.getName());
		this.actionData.setLessonId(lesson.getId());
		ICourseModel course = CustomCourseDao.selectByLessonId(this.getDatabaseHandle().getHandle(), lesson.getId(),
				this.getActionData().getSchema());
		this.actionData.setCourseAuthor(course.getAuthor());
		this.actionData.setCourseDescription(course.getDescription());
		this.actionData.setCourseName(course.getName());
		this.actionData.setCourseId(course.getId());
		ITestModel test = TestDao.selectById(this.getDatabaseHandle().getHandle(), this.actionParam.getTestId(),
				this.getActionData().getSchema());
		this.actionData.setAuthor(test.getAuthor());
		this.actionData.setHtml(test.getHtml());
		this.actionData.setName(test.getName());
		this.actionData.setTestList(CustomTestDao.selectPublicTests(this.getDatabaseHandle().getHandle(),
				this.getActionData().getSchema(), this.actionParam.getLessonId()));
	}

}

/* S.D.G. */
