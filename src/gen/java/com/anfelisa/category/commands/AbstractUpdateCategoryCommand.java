/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.commands;

import de.acegen.Data;
import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

@SuppressWarnings("unused")
public abstract class AbstractUpdateCategoryCommand extends Command<com.anfelisa.category.models.CategoryUpdateModel> {

	public AbstractUpdateCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.category.commands.UpdateCategoryCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(Data<com.anfelisa.category.models.CategoryUpdateModel> data) {
		data.addOutcome("ok");
	}
	
	@Override
	public void addEventsToTimeline(Data<com.anfelisa.category.models.CategoryUpdateModel> data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.category.events.UpdateCategoryOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(Data<com.anfelisa.category.models.CategoryUpdateModel> data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		data.freeze();
		if (data.hasOutcome("ok")){
			new Event<com.anfelisa.category.models.CategoryUpdateModel>("com.anfelisa.category.events.UpdateCategoryOkEvent", viewProvider).publish(data, handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



