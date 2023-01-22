/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

import com.anfelisa.card.data.ICardUpdateData;

@SuppressWarnings("unused")
public abstract class AbstractUpdateCardCommand extends Command<ICardUpdateData> {

	public AbstractUpdateCardCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.card.commands.UpdateCardCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(ICardUpdateData data) {
		data.addOutcome("ok");
	}
	
	@Override
	public void addEventsToTimeline(ICardUpdateData data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.card.events.UpdateCardOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(ICardUpdateData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new Event<ICardUpdateData>("com.anfelisa.card.events.UpdateCardOkEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



