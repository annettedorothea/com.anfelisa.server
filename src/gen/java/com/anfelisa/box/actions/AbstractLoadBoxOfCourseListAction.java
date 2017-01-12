package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxOfCourseListData;


public abstract class AbstractLoadBoxOfCourseListAction extends Action<BoxOfCourseListData> {

	public AbstractLoadBoxOfCourseListAction(DBI jdbi) {
		super("LoadBoxOfCourseListAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
