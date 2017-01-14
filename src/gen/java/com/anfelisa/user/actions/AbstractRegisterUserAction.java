package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UserRegistrationData;

import com.anfelisa.user.commands.RegisterUserCommand;

public abstract class AbstractRegisterUserAction extends Action<UserRegistrationData> {

	public AbstractRegisterUserAction(DBI jdbi) {
		super("RegisterUserAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new RegisterUserCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

}

/*       S.D.G.       */
