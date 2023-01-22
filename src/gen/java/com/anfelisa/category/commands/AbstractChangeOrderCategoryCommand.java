/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

import com.anfelisa.category.data.ICategoryChangeOrderData;

@SuppressWarnings("unused")
public abstract class AbstractChangeOrderCategoryCommand extends Command<ICategoryChangeOrderData> {

	public AbstractChangeOrderCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.category.commands.ChangeOrderCategoryCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(ICategoryChangeOrderData data) {
		data.addOutcome("ok");
	}
	protected void addNoMoveOutcome(ICategoryChangeOrderData data) {
		data.addOutcome("noMove");
	}
	
	@Override
	public void addEventsToTimeline(ICategoryChangeOrderData data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.category.events.ChangeOrderCategoryOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(ICategoryChangeOrderData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new Event<ICategoryChangeOrderData>("com.anfelisa.category.events.ChangeOrderCategoryOkEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



