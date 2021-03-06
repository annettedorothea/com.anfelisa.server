/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.card.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;

import com.anfelisa.card.data.ICardUpdateData;

public abstract class AbstractUpdateCardCommand extends Command<ICardUpdateData> {

	public AbstractUpdateCardCommand(ICardUpdateData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.card.commands.UpdateCardCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	protected void addOkOutcome() {
		this.commandData.addOutcome("ok");
	}

	@Override
	public void publishEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (this.commandData.hasOutcome("ok")){
			new com.anfelisa.card.events.UpdateCardOkEvent(this.commandData, daoProvider, viewProvider, appConfiguration).publish(handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



