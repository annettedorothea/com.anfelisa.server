package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UserCreationData;

import com.anfelisa.user.commands.CreateUserCommand;

public abstract class AbstractCreateUserAction extends Action<UserCreationData> {

	public AbstractCreateUserAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.user.actions.CreateUserAction", HttpMethod.POST, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new CreateUserCommand(this.actionData, databaseHandle);
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
			this.actionData = mapper.readValue(json, UserCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
