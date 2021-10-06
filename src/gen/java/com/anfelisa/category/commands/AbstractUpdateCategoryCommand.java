/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.category.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

import com.anfelisa.category.data.ICategoryUpdateData;

@SuppressWarnings("unused")
public abstract class AbstractUpdateCategoryCommand extends Command<ICategoryUpdateData> {

	public AbstractUpdateCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.category.commands.UpdateCategoryCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(ICategoryUpdateData data) {
		data.addOutcome("ok");
	}
	
	@Override
	public void addEventsToTimeline(ICategoryUpdateData data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.category.events.UpdateCategoryOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(ICategoryUpdateData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new Event<ICategoryUpdateData>("com.anfelisa.category.events.UpdateCategoryOkEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(ICategoryUpdateData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



