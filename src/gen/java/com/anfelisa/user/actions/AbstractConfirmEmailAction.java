package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UsernameData;

import com.anfelisa.user.commands.ConfirmEmailCommand;

public abstract class AbstractConfirmEmailAction extends Action<UsernameData> {

	public AbstractConfirmEmailAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.user.actions.ConfirmEmailAction", HttpMethod.PUT, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new ConfirmEmailCommand(this.actionData, databaseHandle);
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
			this.actionData = mapper.readValue(json, UsernameData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
