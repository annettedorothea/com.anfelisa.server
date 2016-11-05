package com.anfelisa.lesson.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.LessonCreationData;

import com.anfelisa.lesson.commands.CreateLessonCommand;

public abstract class AbstractCreateLessonAction extends Action<LessonCreationData> {

	public AbstractCreateLessonAction(LessonCreationData actionParam, DatabaseHandle databaseHandle) {
		super("CreateLessonAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new CreateLessonCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
