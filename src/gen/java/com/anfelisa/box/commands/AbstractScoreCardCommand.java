/********************************************************************************
 * generated by de.acegen 1.6.4
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
	public void addEventsToTimeline(IScoreCardData data, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			if (data.hasOutcome("score")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.box.events.ScoreCardScoreEvent", data, timelineHandle);
			}
			if (data.hasOutcome("reinforce")){
				daoProvider.getAceDao().addEventToTimeline("com.anfelisa.box.events.ScoreCardReinforceEvent", data, timelineHandle);
			}
		}
	}
	
	@Override
	public void publishEvents(IScoreCardData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (data.hasOutcome("score")){
			new Event<IScoreCardData>("com.anfelisa.box.events.ScoreCardScoreEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
		if (data.hasOutcome("reinforce")){
			new Event<IScoreCardData>("com.anfelisa.box.events.ScoreCardReinforceEvent", viewProvider).publish(data.deepCopy(), handle, timelineHandle);
		}
	}
	
	@Override
	public void publishAfterCommitEvents(IScoreCardData data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
	}
	
}




/******* S.D.G. *******/



