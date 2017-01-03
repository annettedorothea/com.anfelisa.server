package com.anfelisa.lesson.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.LessonData;


public abstract class AbstractGetLessonAction extends Action<LessonData> {

	public AbstractGetLessonAction(LessonData actionParam, DatabaseHandle databaseHandle) {
		super("GetLessonAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
