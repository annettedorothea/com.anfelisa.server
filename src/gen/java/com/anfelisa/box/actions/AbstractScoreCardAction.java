package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.ScoreCardData;

import com.anfelisa.box.commands.ScoreCardCommand;

public abstract class AbstractScoreCardAction extends Action<ScoreCardData> {

	public AbstractScoreCardAction(DBI jdbi) {
		super("ScoreCardAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new ScoreCardCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

}

/*       S.D.G.       */
