/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.user.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.user.data.IForgotPasswordData;

public abstract class AbstractForgotPasswordCommand extends Command<IForgotPasswordData> {

	public AbstractForgotPasswordCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.user.commands.ForgotPasswordCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(IForgotPasswordData data) {
		data.addOutcome("ok");
	}

	protected void addDoesNotExistOutcome(IForgotPasswordData data) {
		data.addOutcome("doesNotExist");
	}

	@Override
	public void publishEvents(IForgotPasswordData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new com.anfelisa.user.events.ForgotPasswordOkEvent(daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(IForgotPasswordData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



