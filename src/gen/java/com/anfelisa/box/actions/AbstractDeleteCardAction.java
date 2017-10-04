package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.CardIdData;

import com.anfelisa.box.commands.DeleteCardCommand;

public abstract class AbstractDeleteCardAction extends Action<CardIdData> {

	public AbstractDeleteCardAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.box.actions.DeleteCardAction", HttpMethod.DELETE, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new DeleteCardCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CardIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
