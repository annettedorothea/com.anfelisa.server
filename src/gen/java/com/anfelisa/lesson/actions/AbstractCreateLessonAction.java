package com.anfelisa.lesson.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.lesson.data.LessonCreationData;

import com.anfelisa.lesson.commands.CreateLessonCommand;

public abstract class AbstractCreateLessonAction extends Action<LessonCreationData> {

	public AbstractCreateLessonAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.lesson.actions.CreateLessonAction", HttpMethod.POST, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new CreateLessonCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

	protected void throwBadRequest() {
		throw new WebApplicationException(Response.Status.BAD_REQUEST);
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, LessonCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
