package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.FillBoxData;

public abstract class AbstractFillBoxWithCardsCommand extends Command<FillBoxData> {

	protected static final String fillBoxWithCards = "fillBoxWithCards";

	public AbstractFillBoxWithCardsCommand(FillBoxData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.FillBoxWithCardsCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case fillBoxWithCards:
			new com.anfelisa.box.events.FillBoxWithCardsEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
	
	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

	protected void throwBadRequest() {
		throw new WebApplicationException(Response.Status.BAD_REQUEST);
	}

}

/*       S.D.G.       */
