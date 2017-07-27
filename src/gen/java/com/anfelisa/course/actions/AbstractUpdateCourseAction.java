package com.anfelisa.course.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.CourseData;

import com.anfelisa.course.commands.UpdateCourseCommand;

public abstract class AbstractUpdateCourseAction extends Action<CourseData> {

	public AbstractUpdateCourseAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.course.actions.UpdateCourseAction", HttpMethod.PUT, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateCourseCommand(this.actionData, databaseHandle);
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
			this.actionData = mapper.readValue(json, CourseData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
