/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.user.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;

@SuppressWarnings("unused")
public abstract class AbstractResetPasswordCommand extends Command<IResetPasswordWithNewPasswordData> {

	public AbstractResetPasswordCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.user.commands.ResetPasswordCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(IResetPasswordWithNewPasswordData data) {
		data.addOutcome("ok");
	}

	@Override
	public void publishEvents(IResetPasswordWithNewPasswordData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new Event<IResetPasswordWithNewPasswordData>("com.anfelisa.user.events.ResetPasswordOkEvent", daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(IResetPasswordWithNewPasswordData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



