package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxListData;


public abstract class AbstractLoadBoxesAction extends Action<BoxListData> {

	public AbstractLoadBoxesAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		super("com.anfelisa.box.actions.LoadBoxesAction", HttpMethod.GET, jdbi, appConfiguration, daoProvider);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, BoxListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
