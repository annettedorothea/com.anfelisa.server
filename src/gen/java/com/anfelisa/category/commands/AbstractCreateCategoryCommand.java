package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DaoProvider;

import com.anfelisa.category.data.CategoryCreationData;

public abstract class AbstractCreateCategoryCommand extends Command<CategoryCreationData> {

	protected static final String ok = "ok";

	public AbstractCreateCategoryCommand(CategoryCreationData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.category.commands.CreateCategoryCommand", commandParam, databaseHandle, daoProvider);
	}

	public AbstractCreateCategoryCommand(DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.category.commands.CreateCategoryCommand", null, databaseHandle, daoProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.category.events.CreateCategoryOkEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, CategoryCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
