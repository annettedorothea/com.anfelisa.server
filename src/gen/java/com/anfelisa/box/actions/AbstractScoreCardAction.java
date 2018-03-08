package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.ScoreCardData;

import com.anfelisa.box.commands.ScoreCardCommand;

public abstract class AbstractScoreCardAction extends Action<ScoreCardData> {

	public AbstractScoreCardAction(DBI jdbi) {
		super("com.anfelisa.box.actions.ScoreCardAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new ScoreCardCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, ScoreCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
