/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.commands;

import de.acegen.Data;
import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

@SuppressWarnings("unused")
public abstract class AbstractInitMyBoxesForDayCommand extends Command<com.anfelisa.box.models.InitMyBoxesDataModel> {

	public AbstractInitMyBoxesForDayCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.InitMyBoxesForDayCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(Data<com.anfelisa.box.models.InitMyBoxesDataModel> data) {
		data.addOutcome("ok");
	}
	
	@Override
	public void addEventsToTimeline(Data<com.anfelisa.box.models.InitMyBoxesDataModel> data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.box.events.InitMyBoxesForDayOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(Data<com.anfelisa.box.models.InitMyBoxesDataModel> data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		data.freeze();
		if (data.hasOutcome("ok")){
			new Event<com.anfelisa.box.models.InitMyBoxesDataModel>("com.anfelisa.box.events.InitMyBoxesForDayOkEvent", viewProvider).publish(data, handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



