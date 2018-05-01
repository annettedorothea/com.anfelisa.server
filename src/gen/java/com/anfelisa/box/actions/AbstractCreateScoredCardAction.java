package com.anfelisa.box.actions;

import javax.ws.rs.WebApplicationException;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.commands.CreateScoredCardCommand;
import com.anfelisa.box.data.ScoredCardData;

public abstract class AbstractCreateScoredCardAction extends Action<ScoredCardData> {

	public AbstractCreateScoredCardAction(DBI jdbi) {
		super("com.anfelisa.box.actions.CreateScoredCardAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new CreateScoredCardCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, ScoredCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
