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
public abstract class AbstractUpdateCardPriorityCommand extends Command<com.anfelisa.card.models.CardUpdatePriorityModel> {

	public AbstractUpdateCardPriorityCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.card.commands.UpdateCardPriorityCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(Data<com.anfelisa.card.models.CardUpdatePriorityModel> data) {
		data.addOutcome("ok");
	}
	
	@Override
	public void addEventsToTimeline(Data<com.anfelisa.card.models.CardUpdatePriorityModel> data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.card.events.UpdateCardPriorityOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(Data<com.anfelisa.card.models.CardUpdatePriorityModel> data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		data.freeze();
		if (data.hasOutcome("ok")){
			new Event<com.anfelisa.card.models.CardUpdatePriorityModel>("com.anfelisa.card.events.UpdateCardPriorityOkEvent", viewProvider).publish(data, handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



