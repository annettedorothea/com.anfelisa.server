package com.anfelisa.lesson.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.MyLessonListData;


public abstract class AbstractLoadPrivateLessonsAction extends Action<MyLessonListData> {

	public AbstractLoadPrivateLessonsAction(DBI jdbi) {
		super("LoadPrivateLessonsAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */
