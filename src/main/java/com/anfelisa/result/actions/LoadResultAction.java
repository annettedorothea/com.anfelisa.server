package com.anfelisa.result.actions;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.models.CustomLessonDao;
import com.anfelisa.lesson.models.ILessonModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.result.data.MyResultData;
import com.anfelisa.result.models.IResultModel;
import com.anfelisa.result.models.ResultDao;
import com.anfelisa.test.models.CustomTestDao;
import com.anfelisa.test.models.ITestModel;
import com.anfelisa.test.models.TestDao;

public class LoadResultAction extends AbstractLoadResultAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadResultAction.class);

	public LoadResultAction(MyResultData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		IResultModel result = ResultDao.selectByResultId(this.getDatabaseHandle().getHandle(), this.actionParam.getResultId(), this.getActionData().getSchema());
		this.actionData.setDate(result.getDate());
		this.actionData.setJson(result.getJson());
		this.actionData.setMaxPoints(result.getMaxPoints());
		this.actionData.setPoints(result.getPoints());
		this.actionData.setTestId(result.getTestId());
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

/*       S.D.G.       */
