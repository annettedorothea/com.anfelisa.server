package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.RecalculateScheduledCardsData;

import com.anfelisa.box.commands.RecalculateScheduledCardsCommand;

public abstract class AbstractRecalculateScheduledCardsAction extends Action<RecalculateScheduledCardsData> {

	public AbstractRecalculateScheduledCardsAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.box.actions.RecalculateScheduledCardsAction", HttpMethod.PUT, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new RecalculateScheduledCardsCommand(this.actionData, databaseHandle);
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
			this.actionData = mapper.readValue(json, RecalculateScheduledCardsData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
