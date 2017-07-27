package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.ReinforceCardListData;


public abstract class AbstractLoadReinforceCardListAction extends Action<ReinforceCardListData> {

	public AbstractLoadReinforceCardListAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.box.actions.LoadReinforceCardListAction", HttpMethod.GET, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

	protected void throwBadRequest() {
		throw new WebApplicationException(Response.Status.BAD_REQUEST);
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, ReinforceCardListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
