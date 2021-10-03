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

import com.anfelisa.box.data.IScoreCardData;

@SuppressWarnings("unused")
public abstract class AbstractScoreCardCommand extends Command<IScoreCardData> {

	public AbstractScoreCardCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.ScoreCardCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addScoreOutcome(IScoreCardData data) {
		data.addOutcome("score");
	}

	protected void addReinforceOutcome(IScoreCardData data) {
		data.addOutcome("reinforce");
	}

	@Override
	public void publishEvents(IScoreCardData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("score")){
			new Event<IScoreCardData>("com.anfelisa.box.events.ScoreCardScoreEvent", daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
		if (data.hasOutcome("reinforce")){
			new Event<IScoreCardData>("com.anfelisa.box.events.ScoreCardReinforceEvent", daoProvider, viewProvider, appConfiguration).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(IScoreCardData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



