package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.DeleteBoxData;

import com.anfelisa.box.commands.DeleteBoxCommand;

public abstract class AbstractDeleteBoxAction extends Action<DeleteBoxData> {

	public AbstractDeleteBoxAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		super("com.anfelisa.box.actions.DeleteBoxAction", HttpMethod.DELETE, jdbi, appConfiguration, daoProvider);
	}

	@Override
	public ICommand getCommand() {
		return new DeleteBoxCommand(this.actionData, databaseHandle, daoProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, DeleteBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
