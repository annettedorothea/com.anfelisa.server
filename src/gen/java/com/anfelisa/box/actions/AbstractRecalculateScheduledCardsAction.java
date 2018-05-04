package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.RecalculateScheduledCardsData;

import com.anfelisa.box.commands.RecalculateScheduledCardsCommand;

public abstract class AbstractRecalculateScheduledCardsAction extends Action<RecalculateScheduledCardsData> {

	public AbstractRecalculateScheduledCardsAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.RecalculateScheduledCardsAction", HttpMethod.PUT, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return new RecalculateScheduledCardsCommand(this.actionData, databaseHandle, daoProvider, viewProvider);
	}

	protected final void loadDataForGetRequest() {
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
