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

import com.anfelisa.user.data.ITokenData;

@SuppressWarnings("unused")
public abstract class AbstractGetTokenCommand extends Command<ITokenData> {

	public AbstractGetTokenCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.user.commands.GetTokenCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(ITokenData data) {
		data.addOutcome("ok");
	}

	@Override
	public void publishEvents(ITokenData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
	@Override
	public void publishAfterCommitEvents(ITokenData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



