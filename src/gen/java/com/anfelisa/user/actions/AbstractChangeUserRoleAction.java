package com.anfelisa.user.actions;

import javax.ws.rs.WebApplicationException;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.commands.ChangeUserRoleCommand;
import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserRoleAction extends Action<ChangeUserRoleData> {

	public AbstractChangeUserRoleAction(DBI jdbi) {
		super("com.anfelisa.user.actions.ChangeUserRoleAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new ChangeUserRoleCommand(this.actionData, databaseHandle);
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
