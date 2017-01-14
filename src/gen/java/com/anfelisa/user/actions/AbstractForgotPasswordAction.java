package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.ForgotPasswordData;

import com.anfelisa.user.commands.ForgotPasswordCommand;

public abstract class AbstractForgotPasswordAction extends Action<ForgotPasswordData> {

	public AbstractForgotPasswordAction(DBI jdbi) {
		super("ForgotPasswordAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new ForgotPasswordCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

	protected void throwBadRequest() {
		throw new WebApplicationException(Response.Status.BAD_REQUEST);
	}

}

/*       S.D.G.       */
