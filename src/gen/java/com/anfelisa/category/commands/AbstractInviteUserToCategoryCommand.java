/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.category.data.IUserToCategoryInvitationData;

public abstract class AbstractInviteUserToCategoryCommand extends Command<IUserToCategoryInvitationData> {

	public AbstractInviteUserToCategoryCommand(IUserToCategoryInvitationData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.category.commands.InviteUserToCategoryCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome() {
		this.commandData.addOutcome("ok");
	}

	@Override
	public void publishEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (this.commandData.hasOutcome("ok")){
			new com.anfelisa.category.events.InviteUserToCategoryOkEvent(this.commandData, daoProvider, viewProvider, appConfiguration).publish(handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



