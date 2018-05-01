package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.category.data.CategoryUpdateData;

public abstract class AbstractUpdateCategoryCommand extends Command<CategoryUpdateData> {

	protected static final String ok = "ok";

	public AbstractUpdateCategoryCommand(CategoryUpdateData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.commands.UpdateCategoryCommand", commandParam, databaseHandle);
	}

	public AbstractUpdateCategoryCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.commands.UpdateCategoryCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.category.events.UpdateCategoryOkEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, CategoryUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
