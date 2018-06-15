package com.anfelisa.user.actions;

import javax.ws.rs.WebApplicationException;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.commands.ConfirmEmailCommand;
import com.anfelisa.user.data.EmailConfirmationData;

public abstract class AbstractConfirmEmailAction extends Action<EmailConfirmationData> {

	public AbstractConfirmEmailAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.actions.ConfirmEmailAction", HttpMethod.PUT, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return new ConfirmEmailCommand(this.actionData, databaseHandle, daoProvider, viewProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, EmailConfirmationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
