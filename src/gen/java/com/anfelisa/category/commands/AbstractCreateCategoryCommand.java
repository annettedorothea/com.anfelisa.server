/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.category.data.ICategoryCreationData;

public abstract class AbstractCreateCategoryCommand extends Command<ICategoryCreationData> {

	public AbstractCreateCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.category.commands.CreateCategoryCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(ICategoryCreationData data) {
		data.addOutcome("ok");
	}

	@Override
	public void publishEvents(ICategoryCreationData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new com.anfelisa.category.events.CreateCategoryOkEvent(daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(ICategoryCreationData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



