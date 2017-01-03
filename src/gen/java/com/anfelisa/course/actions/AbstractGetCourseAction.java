package com.anfelisa.course.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.CourseData;


public abstract class AbstractGetCourseAction extends Action<CourseData> {

	public AbstractGetCourseAction(CourseData actionParam, DatabaseHandle databaseHandle) {
		super("GetCourseAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
