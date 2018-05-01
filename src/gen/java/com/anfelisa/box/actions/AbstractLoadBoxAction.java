package com.anfelisa.box.actions;

import javax.ws.rs.WebApplicationException;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxIdData;


public abstract class AbstractLoadBoxAction extends Action<BoxIdData> {

	public AbstractLoadBoxAction(DBI jdbi) {
		super("com.anfelisa.box.actions.LoadBoxAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, BoxIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
