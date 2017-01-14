package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.CardOfBoxCreationData;

import com.anfelisa.box.commands.CreateCardOfBoxCommand;

public abstract class AbstractCreateCardOfBoxAction extends Action<CardOfBoxCreationData> {

	public AbstractCreateCardOfBoxAction(DBI jdbi) {
		super("CreateCardOfBoxAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new CreateCardOfBoxCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

}

/*       S.D.G.       */
