/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.card.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.card.data.ICardUpdateData;

public abstract class AbstractUpdateCardCommand extends Command<ICardUpdateData> {

	public AbstractUpdateCardCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.card.commands.UpdateCardCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(ICardUpdateData data) {
		data.addOutcome("ok");
	}

	@Override
	public void publishEvents(ICardUpdateData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new com.anfelisa.card.events.UpdateCardOkEvent(daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(ICardUpdateData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



