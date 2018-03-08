package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.PasswordUpdateData;

import com.anfelisa.user.commands.UpdatePasswordCommand;

public abstract class AbstractUpdatePasswordAction extends Action<PasswordUpdateData> {

	public AbstractUpdatePasswordAction(DBI jdbi) {
		super("com.anfelisa.user.actions.UpdatePasswordAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new UpdatePasswordCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, PasswordUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
