/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.box.data.IBoxCreationData;

public abstract class AbstractCreateReverseBoxCommand extends Command<IBoxCreationData> {

	public AbstractCreateReverseBoxCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.CreateReverseBoxCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(IBoxCreationData data) {
		data.addOutcome("ok");
	}

	@Override
	public void publishEvents(IBoxCreationData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new com.anfelisa.box.events.CreateReverseBoxOkEvent(daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(IBoxCreationData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



