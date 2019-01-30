package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.ICategoryCreationData;

public abstract class AbstractCreateCategoryCommand extends Command<ICategoryCreationData> {

	protected static final String sub = "sub";
	protected static final String root = "root";

	public AbstractCreateCategoryCommand(ICategoryCreationData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.CreateCategoryCommand", commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public AbstractCreateCategoryCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.CreateCategoryCommand", null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case sub:
			new com.anfelisa.category.events.CreateCategorySubEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		case root:
			new com.anfelisa.category.events.CreateCategoryRootEvent(this.commandData, databaseHandle, daoProvider, viewProvider).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
