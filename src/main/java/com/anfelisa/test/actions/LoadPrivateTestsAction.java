package com.anfelisa.test.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.models.ILessonModel;
import com.anfelisa.lesson.models.LessonDao;
import com.anfelisa.test.data.MyTestListData;
import com.anfelisa.test.data.MyTestWithResultData;
import com.anfelisa.test.models.CustomTestDao;
import com.anfelisa.test.models.IMyTestModel;

public class LoadPrivateTestsAction extends AbstractLoadPrivateTestsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateTestsAction.class);

	public LoadPrivateTestsAction(MyTestListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		ILessonModel lesson = LessonDao.selectById(this.getDatabaseHandle().getHandle(), this.actionData.getLessonId(),
				this.getActionData().getSchema());
		this.actionData.setLessonDescription(lesson.getDescription());
		this.actionData.setLessonAuthor(lesson.getAuthor());
		this.actionData.setLessonName(lesson.getName());
		ICourseModel course = CustomCourseDao.selectByLessonId(this.getDatabaseHandle().getHandle(),
				this.actionData.getLessonId(), this.getActionData().getSchema());
		this.actionData.setCourseAuthor(course.getAuthor());
		this.actionData.setCourseDescription(course.getDescription());
		this.actionData.setCourseName(course.getName());
		this.actionData.setCourseId(course.getId());
		/*List<IMyTestModel> list = CustomTestDao.selectMyTests(this.getDatabaseHandle().getHandle(),
				this.getActionData().getSchema(), this.actionParam.getLessonId());
		MyTestWithResultData testWithResult = new MyTestWithResultData(id, name, sequence, resultCount, hasResults, uuid, schema);
		testWithResult.setResultAbstractDataList(resultAbstractDataList);*/
		this.actionData.setMyTestWithResultDataList(null);
	}

}

/*       S.D.G.       */
