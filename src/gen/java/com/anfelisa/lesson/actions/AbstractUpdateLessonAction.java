package com.anfelisa.lesson.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.LessonData;

import com.anfelisa.lesson.commands.UpdateLessonCommand;

public abstract class AbstractUpdateLessonAction extends Action<LessonData> {

	public AbstractUpdateLessonAction(LessonData actionParam, DatabaseHandle databaseHandle) {
		super("UpdateLessonAction", HttpMethod.PUT, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateLessonCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
