package com.anfelisa.course.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.CourseListData;


public abstract class AbstractLoadPublicCoursesAction extends Action<CourseListData> {

	public AbstractLoadPublicCoursesAction(CourseListData actionParam, DatabaseHandle databaseHandle) {
		super("LoadPublicCoursesAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
