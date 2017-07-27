package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.RemoveCourseData;

import com.anfelisa.user.commands.RemoveCourseCommand;

public abstract class AbstractRemoveCourseAction extends Action<RemoveCourseData> {

	public AbstractRemoveCourseAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.user.actions.RemoveCourseAction", HttpMethod.DELETE, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new RemoveCourseCommand(this.actionData, databaseHandle);
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
			this.actionData = mapper.readValue(json, RemoveCourseData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
