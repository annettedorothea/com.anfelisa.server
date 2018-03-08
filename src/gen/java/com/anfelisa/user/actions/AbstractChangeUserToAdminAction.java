package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.ChangeUserRoleData;

import com.anfelisa.user.commands.ChangeUserToAdminCommand;

public abstract class AbstractChangeUserToAdminAction extends Action<ChangeUserRoleData> {

	public AbstractChangeUserToAdminAction(DBI jdbi) {
		super("com.anfelisa.user.actions.ChangeUserToAdminAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new ChangeUserToAdminCommand(this.actionData, databaseHandle);
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
