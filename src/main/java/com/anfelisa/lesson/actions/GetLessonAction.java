package com.anfelisa.lesson.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonData;
import com.anfelisa.lesson.models.ILessonModel;
import com.anfelisa.lesson.models.LessonDao;

public class GetLessonAction extends AbstractGetLessonAction {

	static final Logger LOG = LoggerFactory.getLogger(GetLessonAction.class);

	public GetLessonAction(LessonData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		// init actionData
		this.actionData = this.actionParam;
		ILessonModel lesson = LessonDao.selectByLessonId(this.getDatabaseHandle().getHandle(), this.actionData.getLessonId(), this.actionData.getSchema());
		this.actionData.setAuthor(lesson.getAuthor());
		this.actionData.setCourseId(lesson.getCourseId());
		this.actionData.setDescription(lesson.getDescription());
		this.actionData.setName(lesson.getName());
		this.actionData.setSequence(lesson.getSequence());
	}

}

/*       S.D.G.       */
