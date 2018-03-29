package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.ReinforceCardListData;

public abstract class AbstractLoadReinforceCardListCommand extends Command<ReinforceCardListData> {


	public AbstractLoadReinforceCardListCommand(ReinforceCardListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.LoadReinforceCardListCommand", commandParam, databaseHandle);
	}

	public AbstractLoadReinforceCardListCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.LoadReinforceCardListCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, ReinforceCardListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
