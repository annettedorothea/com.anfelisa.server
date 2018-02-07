package com.anfelisa.lesson.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.SimpleLessonListData;


public abstract class AbstractGetAllLessonsAction extends Action<SimpleLessonListData> {

	public AbstractGetAllLessonsAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.lesson.actions.GetAllLessonsAction", HttpMethod.GET, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, SimpleLessonListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
