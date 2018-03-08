package com.anfelisa.lesson.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.LessonIdData;

import com.anfelisa.lesson.commands.DeleteLessonCommand;

public abstract class AbstractDeleteLessonAction extends Action<LessonIdData> {

	public AbstractDeleteLessonAction(DBI jdbi) {
		super("com.anfelisa.lesson.actions.DeleteLessonAction", HttpMethod.DELETE, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new DeleteLessonCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, LessonIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
