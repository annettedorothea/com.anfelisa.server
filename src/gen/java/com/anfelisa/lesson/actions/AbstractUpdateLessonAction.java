package com.anfelisa.lesson.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.LessonData;

import com.anfelisa.lesson.commands.UpdateLessonCommand;

public abstract class AbstractUpdateLessonAction extends Action<LessonData> {

	public AbstractUpdateLessonAction(DBI jdbi) {
		super("UpdateLessonAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateLessonCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
