package com.anfelisa.course.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.CourseCreationData;

import com.anfelisa.course.commands.CreateCourseCommand;

public abstract class AbstractCreateCourseAction extends Action<CourseCreationData> {

	public AbstractCreateCourseAction(CourseCreationData actionParam, DatabaseHandle databaseHandle) {
		super("CreateCourseAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new CreateCourseCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
