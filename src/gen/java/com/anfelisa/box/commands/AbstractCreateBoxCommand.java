/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.box.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.box.data.IBoxCreationData;

public abstract class AbstractCreateBoxCommand extends Command<IBoxCreationData> {

	protected static final String ok = "ok";

	public AbstractCreateBoxCommand(IBoxCreationData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.CreateBoxCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	public void publishEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case ok:
			new com.anfelisa.box.events.CreateBoxOkEvent(this.commandData, daoProvider, viewProvider, appConfiguration).publish(handle, timelineHandle);
			break;
		default:
			throw new RuntimeException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}




/******* S.D.G. *******/



