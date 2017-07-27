package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UserUpdateData;

import com.anfelisa.user.commands.UpdateUserCommand;

public abstract class AbstractUpdateUserAction extends Action<UserUpdateData> {

	public AbstractUpdateUserAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.user.actions.UpdateUserAction", HttpMethod.PUT, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateUserCommand(this.actionData, databaseHandle);
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
			this.actionData = mapper.readValue(json, UserUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
