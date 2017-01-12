package com.anfelisa.lesson.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.LessonCreationData;

import com.anfelisa.lesson.commands.CreateLessonCommand;

public abstract class AbstractCreateLessonAction extends Action<LessonCreationData> {

	public AbstractCreateLessonAction(DBI jdbi) {
		super("CreateLessonAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new CreateLessonCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
