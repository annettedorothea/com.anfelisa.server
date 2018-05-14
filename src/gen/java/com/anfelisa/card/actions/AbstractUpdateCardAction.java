package com.anfelisa.card.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.card.data.CardUpdateData;

import com.anfelisa.card.commands.UpdateCardCommand;

public abstract class AbstractUpdateCardAction extends Action<CardUpdateData> {

	public AbstractUpdateCardAction(DBI jdbi, AppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.actions.UpdateCardAction", HttpMethod.PUT, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateCardCommand(this.actionData, databaseHandle, daoProvider, viewProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CardUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
