package com.anfelisa.card.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.card.data.CardDeleteData;

import com.anfelisa.card.commands.DeleteCardCommand;

public abstract class AbstractDeleteCardAction extends Action<CardDeleteData> {

	public AbstractDeleteCardAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		super("com.anfelisa.card.actions.DeleteCardAction", HttpMethod.DELETE, jdbi, appConfiguration, daoProvider);
	}

	@Override
	public ICommand getCommand() {
		return new DeleteCardCommand(this.actionData, databaseHandle, daoProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CardDeleteData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
