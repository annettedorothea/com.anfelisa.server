/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.card.data.ICardUpdatePriorityData;

public abstract class AbstractUpdateCardPriorityCommand extends Command<ICardUpdatePriorityData> {

	public AbstractUpdateCardPriorityCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.card.commands.UpdateCardPriorityCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(ICardUpdatePriorityData data) {
		data.addOutcome("ok");
	}

	@Override
	public void publishEvents(ICardUpdatePriorityData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new com.anfelisa.card.events.UpdateCardPriorityOkEvent(daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(ICardUpdatePriorityData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



