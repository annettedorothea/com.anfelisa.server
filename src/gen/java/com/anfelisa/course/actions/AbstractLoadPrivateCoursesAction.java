package com.anfelisa.course.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.MyCourseListData;


public abstract class AbstractLoadPrivateCoursesAction extends Action<MyCourseListData> {

	public AbstractLoadPrivateCoursesAction(MyCourseListData actionParam, DatabaseHandle databaseHandle) {
		super("LoadPrivateCoursesAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
