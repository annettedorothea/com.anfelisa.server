package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.category.data.CategoryCreationData;

public abstract class AbstractCreateCategoryCommand extends Command<CategoryCreationData> {

	protected static final String ok = "ok";

	public AbstractCreateCategoryCommand(CategoryCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.commands.CreateCategoryCommand", commandParam, databaseHandle);
	}

	public AbstractCreateCategoryCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.commands.CreateCategoryCommand", null, databaseHandle);
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
