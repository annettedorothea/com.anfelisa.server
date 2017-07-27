package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxConfigData;

import com.anfelisa.box.commands.SaveBoxConfigCommand;

public abstract class AbstractSaveBoxConfigAction extends Action<BoxConfigData> {

	public AbstractSaveBoxConfigAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.box.actions.SaveBoxConfigAction", HttpMethod.PUT, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new SaveBoxConfigCommand(this.actionData, databaseHandle);
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
			this.actionData = mapper.readValue(json, BoxConfigData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
