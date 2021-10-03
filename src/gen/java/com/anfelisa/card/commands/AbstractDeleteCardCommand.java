/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.card.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

import com.anfelisa.card.data.ICardDeleteData;

@SuppressWarnings("unused")
public abstract class AbstractDeleteCardCommand extends Command<ICardDeleteData> {

	public AbstractDeleteCardCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.card.commands.DeleteCardCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome(ICardDeleteData data) {
		data.addOutcome("ok");
	}

	@Override
	public void publishEvents(ICardDeleteData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("ok")){
			new Event<ICardDeleteData>("com.anfelisa.card.events.DeleteCardOkEvent", daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(ICardDeleteData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



