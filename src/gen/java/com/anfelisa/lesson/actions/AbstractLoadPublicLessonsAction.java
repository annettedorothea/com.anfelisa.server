package com.anfelisa.lesson.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.LessonListData;


public abstract class AbstractLoadPublicLessonsAction extends Action<LessonListData> {

	public AbstractLoadPublicLessonsAction(LessonListData actionParam, DatabaseHandle databaseHandle) {
		super("LoadPublicLessonsAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
