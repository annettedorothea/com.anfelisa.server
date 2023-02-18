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

import com.anfelisa.card.models.CardCreationModel;

@SuppressWarnings("unused")
public abstract class AbstractCreateCardCommand extends Command<com.anfelisa.card.models.CardCreationModel> {

	public AbstractCreateCardCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.card.commands.CreateCardCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(Data<com.anfelisa.card.models.CardCreationModel> data) {
		data.addOutcome("ok");
	}
	
	@Override
	public void addEventsToTimeline(Data<com.anfelisa.card.models.CardCreationModel> data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.card.events.CreateCardOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(Data<com.anfelisa.card.models.CardCreationModel> data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		data.freeze();
		if (data.hasOutcome("ok")){
			new Event<com.anfelisa.card.models.CardCreationModel>("com.anfelisa.card.events.CreateCardOkEvent", viewProvider).publish(data, handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



