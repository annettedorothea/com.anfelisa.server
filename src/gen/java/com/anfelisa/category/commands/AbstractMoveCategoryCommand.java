package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.ICategoryMoveData;

public abstract class AbstractMoveCategoryCommand extends Command<ICategoryMoveData> {

	protected static final String ok = "ok";
	protected static final String noMove = "noMove";

	public AbstractMoveCategoryCommand(ICategoryMoveData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.MoveCategoryCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractMoveCategoryCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.MoveCategoryCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.category.events.MoveCategoryOkEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		case noMove:
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
