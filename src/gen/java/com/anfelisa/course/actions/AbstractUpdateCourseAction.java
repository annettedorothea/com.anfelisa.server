package com.anfelisa.course.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.CourseData;

import com.anfelisa.course.commands.UpdateCourseCommand;

public abstract class AbstractUpdateCourseAction extends Action<CourseData> {

	public AbstractUpdateCourseAction(DBI jdbi) {
		super("com.anfelisa.course.actions.UpdateCourseAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateCourseCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
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
