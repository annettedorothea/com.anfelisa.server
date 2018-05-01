package com.anfelisa.user.actions;

import javax.ws.rs.WebApplicationException;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.commands.UpdateUserCommand;
import com.anfelisa.user.data.UserUpdateData;

public abstract class AbstractUpdateUserAction extends Action<UserUpdateData> {

	public AbstractUpdateUserAction(DBI jdbi) {
		super("com.anfelisa.user.actions.UpdateUserAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateUserCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, UserUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
