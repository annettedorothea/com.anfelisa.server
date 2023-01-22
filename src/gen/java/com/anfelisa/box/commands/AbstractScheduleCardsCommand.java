/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

import com.anfelisa.box.data.IScheduledCardsData;

@SuppressWarnings("unused")
public abstract class AbstractScheduleCardsCommand extends Command<IScheduledCardsData> {

	public AbstractScheduleCardsCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.ScheduleCardsCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(IScheduledCardsData data) {
		data.addOutcome("ok");
	}
	protected void addNullOrEmptyOutcome(IScheduledCardsData data) {
		data.addOutcome("nullOrEmpty");
	}
	
	@Override
	public void addEventsToTimeline(IScheduledCardsData data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.box.events.ScheduleCardsOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(IScheduledCardsData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new Event<IScheduledCardsData>("com.anfelisa.box.events.ScheduleCardsOkEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



