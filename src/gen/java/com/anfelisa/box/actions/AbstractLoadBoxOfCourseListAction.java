package com.anfelisa.box.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxOfCourseListData;


public abstract class AbstractLoadBoxOfCourseListAction extends Action<BoxOfCourseListData> {

	public AbstractLoadBoxOfCourseListAction(BoxOfCourseListData actionParam, DatabaseHandle databaseHandle) {
		super("LoadBoxOfCourseListAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
