/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.commands;

import de.acegen.Data;
import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

@SuppressWarnings("unused")
public abstract class AbstractConfirmEmailCommand extends Command<com.anfelisa.user.models.ConfirmEmailModel> {

	public AbstractConfirmEmailCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.user.commands.ConfirmEmailCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(Data<com.anfelisa.user.models.ConfirmEmailModel> data) {
		data.addOutcome("ok");
	}
	protected void addAlreadyConfirmedOutcome(Data<com.anfelisa.user.models.ConfirmEmailModel> data) {
		data.addOutcome("alreadyConfirmed");
	}
	
	@Override
	public void addEventsToTimeline(Data<com.anfelisa.user.models.ConfirmEmailModel> data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.user.events.ConfirmEmailOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(Data<com.anfelisa.user.models.ConfirmEmailModel> data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		data.freeze();
		if (data.hasOutcome("ok")){
			new Event<com.anfelisa.user.models.ConfirmEmailModel>("com.anfelisa.user.events.ConfirmEmailOkEvent", viewProvider).publish(data, handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



