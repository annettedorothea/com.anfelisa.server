package com.anfelisa.lesson.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.LessonListData;


public abstract class AbstractLoadPublicLessonsAction extends Action<LessonListData> {

	public AbstractLoadPublicLessonsAction(DBI jdbi) {
		super("com.anfelisa.lesson.actions.LoadPublicLessonsAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, LessonListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
