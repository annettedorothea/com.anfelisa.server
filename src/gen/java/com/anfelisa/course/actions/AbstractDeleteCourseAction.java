package com.anfelisa.course.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.CourseIdData;

import com.anfelisa.course.commands.DeleteCourseCommand;

public abstract class AbstractDeleteCourseAction extends Action<CourseIdData> {

	public AbstractDeleteCourseAction(DBI jdbi) {
		super("com.anfelisa.course.actions.DeleteCourseAction", HttpMethod.DELETE, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new DeleteCourseCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CourseIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
