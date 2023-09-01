/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.commands;

import de.acegen.Data;
import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

@SuppressWarnings("unused")
public abstract class AbstractChangeOrderCommand extends Command<com.anfelisa.card.models.ChangeCardOrderListModel> {

	public AbstractChangeOrderCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.card.commands.ChangeOrderCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(Data<com.anfelisa.card.models.ChangeCardOrderListModel> data) {
		data.addOutcome("ok");
	}
	protected void addNoMoveOutcome(Data<com.anfelisa.card.models.ChangeCardOrderListModel> data) {
		data.addOutcome("noMove");
	}
	
	@Override
	public void addEventsToTimeline(Data<com.anfelisa.card.models.ChangeCardOrderListModel> data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.card.events.ChangeOrderOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(Data<com.anfelisa.card.models.ChangeCardOrderListModel> data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		data.freeze();
		if (data.hasOutcome("ok")){
			new Event<com.anfelisa.card.models.ChangeCardOrderListModel>("com.anfelisa.card.events.ChangeOrderOkEvent", viewProvider).publish(data, handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



