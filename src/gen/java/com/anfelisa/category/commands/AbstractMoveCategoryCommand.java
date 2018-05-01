package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.category.data.CategoryMoveData;

public abstract class AbstractMoveCategoryCommand extends Command<CategoryMoveData> {

	protected static final String ok = "ok";

	public AbstractMoveCategoryCommand(CategoryMoveData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.commands.MoveCategoryCommand", commandParam, databaseHandle);
	}

	public AbstractMoveCategoryCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.category.commands.MoveCategoryCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.category.events.MoveCategoryOkEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, CategoryMoveData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
