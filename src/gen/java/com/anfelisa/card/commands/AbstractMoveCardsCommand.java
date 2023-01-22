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

import com.anfelisa.card.data.IMoveCardsData;

@SuppressWarnings("unused")
public abstract class AbstractMoveCardsCommand extends Command<IMoveCardsData> {

	public AbstractMoveCardsCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.card.commands.MoveCardsCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(IMoveCardsData data) {
		data.addOutcome("ok");
	}
	
	@Override
	public void addEventsToTimeline(IMoveCardsData data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.card.events.MoveCardsOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(IMoveCardsData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new Event<IMoveCardsData>("com.anfelisa.card.events.MoveCardsOkEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



