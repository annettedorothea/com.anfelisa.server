package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UserRegistrationData;

import com.anfelisa.user.commands.RegisterUserCommand;

public abstract class AbstractRegisterUserAction extends Action<UserRegistrationData> {

	public AbstractRegisterUserAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		super("com.anfelisa.user.actions.RegisterUserAction", HttpMethod.POST, jdbi, appConfiguration, daoProvider);
	}

	@Override
	public ICommand getCommand() {
		return new RegisterUserCommand(this.actionData, databaseHandle, daoProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, UserRegistrationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
