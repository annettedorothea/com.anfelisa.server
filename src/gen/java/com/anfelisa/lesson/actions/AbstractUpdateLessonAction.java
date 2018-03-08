package com.anfelisa.lesson.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.LessonData;

import com.anfelisa.lesson.commands.UpdateLessonCommand;

public abstract class AbstractUpdateLessonAction extends Action<LessonData> {

	public AbstractUpdateLessonAction(DBI jdbi) {
		super("com.anfelisa.lesson.actions.UpdateLessonAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateLessonCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, LessonData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
