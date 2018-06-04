package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxInfoData;


public abstract class AbstractGetBoxAction extends Action<BoxInfoData> {

	public AbstractGetBoxAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.GetBoxAction", HttpMethod.GET, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, BoxInfoData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */