package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DaoProvider;

import com.anfelisa.category.data.CategoryDeleteData;

public abstract class AbstractDeleteCategoryCommand extends Command<CategoryDeleteData> {

	protected static final String ok = "ok";

	public AbstractDeleteCategoryCommand(CategoryDeleteData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.category.commands.DeleteCategoryCommand", commandParam, databaseHandle, daoProvider);
	}

	public AbstractDeleteCategoryCommand(DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.category.commands.DeleteCategoryCommand", null, databaseHandle, daoProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.category.events.DeleteCategoryOkEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, CategoryDeleteData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
