package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.ChangeUserRoleData;

import com.anfelisa.user.commands.ChangeUserToPremiumCommand;

public abstract class AbstractChangeUserToPremiumAction extends Action<ChangeUserRoleData> {

	public AbstractChangeUserToPremiumAction(DBI jdbi) {
		super("com.anfelisa.user.actions.ChangeUserToPremiumAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new ChangeUserToPremiumCommand(this.actionData, databaseHandle);
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
