/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.box.commands;

import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

import com.anfelisa.box.data.IScoreReinforceCardData;

@SuppressWarnings("unused")
public abstract class AbstractScoreReinforceCardCommand extends Command<IScoreReinforceCardData> {

	public AbstractScoreReinforceCardCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.ScoreReinforceCardCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addKeepOutcome(IScoreReinforceCardData data) {
		data.addOutcome("keep");
	}

	protected void addRemoveOutcome(IScoreReinforceCardData data) {
		data.addOutcome("remove");
	}

	@Override
	public void publishEvents(IScoreReinforceCardData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("keep")){
			new Event<IScoreReinforceCardData>("com.anfelisa.box.events.ScoreReinforceCardKeepEvent", daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
		if (data.hasOutcome("remove")){
			new Event<IScoreReinforceCardData>("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent", daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(IScoreReinforceCardData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



