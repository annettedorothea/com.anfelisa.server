package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.RoleData;


public abstract class AbstractGetRoleAction extends Action<RoleData> {

	public AbstractGetRoleAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		super("com.anfelisa.user.actions.GetRoleAction", HttpMethod.GET, jdbi, appConfiguration, daoProvider);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, RoleData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
