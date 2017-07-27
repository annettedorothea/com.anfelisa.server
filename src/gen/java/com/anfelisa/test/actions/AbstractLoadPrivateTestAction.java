package com.anfelisa.test.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.MyTestData;


public abstract class AbstractLoadPrivateTestAction extends Action<MyTestData> {

	public AbstractLoadPrivateTestAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.test.actions.LoadPrivateTestAction", HttpMethod.GET, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

	protected void throwBadRequest() {
		throw new WebApplicationException(Response.Status.BAD_REQUEST);
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, MyTestData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
