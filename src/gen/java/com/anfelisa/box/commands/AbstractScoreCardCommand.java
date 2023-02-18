/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.commands;

import de.acegen.Data;
import de.acegen.Command;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.PersistenceHandle;
import de.acegen.Event;

@SuppressWarnings("unused")
public abstract class AbstractScoreCardCommand extends Command<com.anfelisa.box.models.ScoreCardModel> {

	public AbstractScoreCardCommand(IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.ScoreCardCommand", daoProvider, viewProvider, appConfiguration);
	}

	protected void addScoreOutcome(Data<com.anfelisa.box.models.ScoreCardModel> data) {
		data.addOutcome("score");
	}
	protected void addReinforceOutcome(Data<com.anfelisa.box.models.ScoreCardModel> data) {
		data.addOutcome("reinforce");
	}
	
	@Override
	public void addEventsToTimeline(Data<com.anfelisa.box.models.ScoreCardModel> data, PersistenceHandle timelineHandle) {
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
	public void publishEvents(Data<com.anfelisa.box.models.ScoreCardModel> data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		data.freeze();
		if (data.hasOutcome("score")){
			new Event<com.anfelisa.box.models.ScoreCardModel>("com.anfelisa.box.events.ScoreCardScoreEvent", viewProvider).publish(data, handle, timelineHandle);
		}
		if (data.hasOutcome("reinforce")){
			new Event<com.anfelisa.box.models.ScoreCardModel>("com.anfelisa.box.events.ScoreCardReinforceEvent", viewProvider).publish(data, handle, timelineHandle);
		}
	}
	
}




/******* S.D.G. *******/



