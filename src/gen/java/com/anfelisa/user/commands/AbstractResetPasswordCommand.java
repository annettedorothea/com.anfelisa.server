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

import com.anfelisa.user.models.ResetPasswordWithNewPasswordModel;

@SuppressWarnings("unused")
public abstract class AbstractResetPasswordCommand extends Command<com.anfelisa.user.models.ResetPasswordWithNewPasswordModel> {

	public AbstractResetPasswordCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.user.commands.ResetPasswordCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(Data<com.anfelisa.user.models.ResetPasswordWithNewPasswordModel> data) {
		data.addOutcome("ok");
	}
	
	@Override
	public void addEventsToTimeline(Data<com.anfelisa.user.models.ResetPasswordWithNewPasswordModel> data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.user.events.ResetPasswordOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(Data<com.anfelisa.user.models.ResetPasswordWithNewPasswordModel> data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		data.freeze();
		if (data.hasOutcome("ok")){
			new Event<com.anfelisa.user.models.ResetPasswordWithNewPasswordModel>("com.anfelisa.user.events.ResetPasswordOkEvent", viewProvider).publish(data, handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



