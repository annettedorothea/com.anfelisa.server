/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.category.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.category.data.ICategoryMoveData;

public abstract class AbstractMoveCategoryCommand extends Command<ICategoryMoveData> {

	public AbstractMoveCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.category.commands.MoveCategoryCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(ICategoryMoveData data) {
		data.addOutcome("ok");
	}

	protected void addNoMoveOutcome(ICategoryMoveData data) {
		data.addOutcome("noMove");
	}

	@Override
	public void publishEvents(ICategoryMoveData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new com.anfelisa.category.events.MoveCategoryOkEvent(daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(ICategoryMoveData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



