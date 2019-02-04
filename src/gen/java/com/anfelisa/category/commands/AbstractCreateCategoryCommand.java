package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.ICategoryCreationData;

public abstract class AbstractCreateCategoryCommand extends Command<ICategoryCreationData> {

	protected static final String sub = "sub";
	protected static final String root = "root";

	public AbstractCreateCategoryCommand(ICategoryCreationData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.CreateCategoryCommand", commandParam, daoProvider, viewProvider);
	}

	public AbstractCreateCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.CreateCategoryCommand", null, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case sub:
			new com.anfelisa.category.events.CreateCategorySubEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		case root:
			new com.anfelisa.category.events.CreateCategoryRootEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
