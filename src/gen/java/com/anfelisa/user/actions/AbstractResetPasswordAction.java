package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.ResetPasswordData;

import com.anfelisa.user.commands.ResetPasswordCommand;

public abstract class AbstractResetPasswordAction extends Action<ResetPasswordData> {

	public AbstractResetPasswordAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		super("com.anfelisa.user.actions.ResetPasswordAction", HttpMethod.PUT, jdbi, appConfiguration, daoProvider);
	}

	@Override
	public ICommand getCommand() {
		return new ResetPasswordCommand(this.actionData, databaseHandle, daoProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, ResetPasswordData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
