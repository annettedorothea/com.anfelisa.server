package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.ChangeUserRoleData;

import com.anfelisa.user.commands.ChangeUserRoleCommand;

public abstract class AbstractChangeUserRoleAction extends Action<ChangeUserRoleData> {

	public AbstractChangeUserRoleAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		super("com.anfelisa.user.actions.ChangeUserRoleAction", HttpMethod.PUT, jdbi, appConfiguration, daoProvider);
	}

	@Override
	public ICommand getCommand() {
		return new ChangeUserRoleCommand(this.actionData, databaseHandle, daoProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, ChangeUserRoleData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
