package com.anfelisa.user.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.CourseSelectionData;


public abstract class AbstractGetCourseSelectionAction extends Action<CourseSelectionData> {

	public AbstractGetCourseSelectionAction(CourseSelectionData actionParam, DatabaseHandle databaseHandle) {
		super("GetCourseSelectionAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
