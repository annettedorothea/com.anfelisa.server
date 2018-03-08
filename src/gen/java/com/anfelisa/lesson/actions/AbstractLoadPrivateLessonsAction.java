package com.anfelisa.lesson.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.MyLessonListData;


public abstract class AbstractLoadPrivateLessonsAction extends Action<MyLessonListData> {

	public AbstractLoadPrivateLessonsAction(DBI jdbi) {
		super("com.anfelisa.lesson.actions.LoadPrivateLessonsAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, MyLessonListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
