/********************************************************************************
 * generated by de.acegen 1.5.4
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

	protected void addOkOutcome(IUserToCategoryInvitationData data) {
		data.addOutcome("ok");
	}

	@Override
	public void publishEvents(IUserToCategoryInvitationData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new Event<IUserToCategoryInvitationData>("com.anfelisa.category.events.InviteUserToCategoryOkEvent", daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(IUserToCategoryInvitationData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



