package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.RemoveCardFromBoxData;

import com.anfelisa.box.commands.RemoveCardFromBoxCommand;

public abstract class AbstractRemoveCardFromBoxAction extends Action<RemoveCardFromBoxData> {

	public AbstractRemoveCardFromBoxAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.box.actions.RemoveCardFromBoxAction", HttpMethod.DELETE, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new RemoveCardFromBoxCommand(this.actionData, databaseHandle);
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
			this.actionData = mapper.readValue(json, RemoveCardFromBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
