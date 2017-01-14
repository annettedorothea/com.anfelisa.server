package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UsernameData;

import com.anfelisa.user.commands.ConfirmEmailCommand;

public abstract class AbstractConfirmEmailAction extends Action<UsernameData> {

	public AbstractConfirmEmailAction(DBI jdbi) {
		super("ConfirmEmailAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new ConfirmEmailCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

}

/*       S.D.G.       */
