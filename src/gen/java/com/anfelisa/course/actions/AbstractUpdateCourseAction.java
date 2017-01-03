package com.anfelisa.course.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.CourseData;

import com.anfelisa.course.commands.UpdateCourseCommand;

public abstract class AbstractUpdateCourseAction extends Action<CourseData> {

	public AbstractUpdateCourseAction(CourseData actionParam, DatabaseHandle databaseHandle) {
		super("UpdateCourseAction", HttpMethod.PUT, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateCourseCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
