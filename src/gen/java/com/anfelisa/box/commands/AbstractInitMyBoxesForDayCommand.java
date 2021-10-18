/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.box.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

import com.anfelisa.box.data.IInitMyBoxesDataData;

@SuppressWarnings("unused")
public abstract class AbstractInitMyBoxesForDayCommand extends Command<IInitMyBoxesDataData> {

	public AbstractInitMyBoxesForDayCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.InitMyBoxesForDayCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(IInitMyBoxesDataData data) {
		data.addOutcome("ok");
	}
	
	@Override
	public void addEventsToTimeline(IInitMyBoxesDataData data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.box.events.InitMyBoxesForDayOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(IInitMyBoxesDataData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new Event<IInitMyBoxesDataData>("com.anfelisa.box.events.InitMyBoxesForDayOkEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(IInitMyBoxesDataData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



