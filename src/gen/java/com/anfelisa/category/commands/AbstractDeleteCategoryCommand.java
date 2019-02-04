package com.anfelisa.category.commands;

import javax.ws.rs.WebApplicationException;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.ICategoryDeleteData;

public abstract class AbstractDeleteCategoryCommand extends Command<ICategoryDeleteData> {

	protected static final String noRoot = "noRoot";
	protected static final String root = "root";

	public AbstractDeleteCategoryCommand(ICategoryDeleteData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.DeleteCategoryCommand", commandParam, daoProvider, viewProvider);
	}

	public AbstractDeleteCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.commands.DeleteCategoryCommand", null, daoProvider, viewProvider);
	}

	@Override
	public void publishEvents(Handle handle, Handle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case noRoot:
			new com.anfelisa.category.events.DeleteCategoryNoRootEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		case root:
			new com.anfelisa.category.events.DeleteCategoryRootEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}

/*       S.D.G.       */
