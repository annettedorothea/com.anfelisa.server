/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.card.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

import com.anfelisa.card.data.IChangeCardOrderListData;

@SuppressWarnings("unused")
public abstract class AbstractChangeOrderCommand extends Command<IChangeCardOrderListData> {

	public AbstractChangeOrderCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.card.commands.ChangeOrderCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(IChangeCardOrderListData data) {
		data.addOutcome("ok");
	}
	
	@Override
	public void addEventsToTimeline(IChangeCardOrderListData data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.card.events.ChangeOrderOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(IChangeCardOrderListData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new Event<IChangeCardOrderListData>("com.anfelisa.card.events.ChangeOrderOkEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(IChangeCardOrderListData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



