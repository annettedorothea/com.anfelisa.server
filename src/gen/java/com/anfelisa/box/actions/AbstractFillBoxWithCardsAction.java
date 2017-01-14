package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.FillBoxData;

import com.anfelisa.box.commands.FillBoxWithCardsCommand;

public abstract class AbstractFillBoxWithCardsAction extends Action<FillBoxData> {

	public AbstractFillBoxWithCardsAction(DBI jdbi) {
		super("FillBoxWithCardsAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new FillBoxWithCardsCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

}

/*       S.D.G.       */
