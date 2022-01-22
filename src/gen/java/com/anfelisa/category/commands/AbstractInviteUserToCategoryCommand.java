/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

import com.anfelisa.category.data.IUserToCategoryInvitationData;

@SuppressWarnings("unused")
public abstract class AbstractInviteUserToCategoryCommand extends Command<IUserToCategoryInvitationData> {

	public AbstractInviteUserToCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.category.commands.InviteUserToCategoryCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addInsertOutcome(IUserToCategoryInvitationData data) {
		data.addOutcome("insert");
	}
	protected void addUpdateOutcome(IUserToCategoryInvitationData data) {
		data.addOutcome("update");
	}
	
	@Override
	public void addEventsToTimeline(IUserToCategoryInvitationData data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("insert")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.category.events.InviteUserToCategoryInsertEvent", data, timelineHandle);
			}
			if (data.hasOutcome("update")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.category.events.InviteUserToCategoryUpdateEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(IUserToCategoryInvitationData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("insert")){
			new Event<IUserToCategoryInvitationData>("com.anfelisa.category.events.InviteUserToCategoryInsertEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
		if (data.hasOutcome("update")){
			new Event<IUserToCategoryInvitationData>("com.anfelisa.category.events.InviteUserToCategoryUpdateEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(IUserToCategoryInvitationData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



