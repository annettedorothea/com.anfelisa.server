/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.user.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

import com.anfelisa.user.data.IDeleteUserData;

@SuppressWarnings("unused")
public abstract class AbstractDeleteUserCommand extends Command<IDeleteUserData> {

	public AbstractDeleteUserCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.user.commands.DeleteUserCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(IDeleteUserData data) {
		data.addOutcome("ok");
	}
	
	@Override
	public void addEventsToTimeline(IDeleteUserData data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("ok")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.user.events.DeleteUserOkEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(IDeleteUserData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new Event<IDeleteUserData>("com.anfelisa.user.events.DeleteUserOkEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(IDeleteUserData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



