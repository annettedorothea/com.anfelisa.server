package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

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

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, UsernameData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
