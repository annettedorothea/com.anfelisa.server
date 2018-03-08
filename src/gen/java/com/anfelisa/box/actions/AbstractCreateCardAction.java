package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.CardCreationData;

import com.anfelisa.box.commands.CreateCardCommand;

public abstract class AbstractCreateCardAction extends Action<CardCreationData> {

	public AbstractCreateCardAction(DBI jdbi) {
		super("com.anfelisa.box.actions.CreateCardAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new CreateCardCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CardCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
