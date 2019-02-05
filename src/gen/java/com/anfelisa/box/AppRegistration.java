package com.anfelisa.box;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;
import com.anfelisa.ace.E2E;

import org.jdbi.v3.core.Jdbi;


import com.anfelisa.box.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		environment.jersey().register(new GetBoxesAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetBoxAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new CreateBoxAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new UpdateBoxAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new PostponeCardsAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new DeleteBoxAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new LoadNextCardAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new LoadNextReinforceCardAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ScheduleNextCardAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ScheduleCardsAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ScoreCardAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ScoreReinforceCardAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
	}

	public static void registerConsumers(ViewProvider viewProvider, String mode) {
		viewProvider.addConsumer("com.anfelisa.box.events.CreateBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.createBox((com.anfelisa.box.data.BoxData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.UpdateBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.updateBox((com.anfelisa.box.data.BoxUpdateData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.PostponeCardsOkEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.postponeCards((com.anfelisa.box.data.PostponeCardsData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.DeleteBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.deleteBox((com.anfelisa.box.data.DeleteBoxData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScheduleNextCardOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.scheduleCard((com.anfelisa.box.data.ScheduleNextCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScheduleCardsOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.scheduleCards((com.anfelisa.box.data.ScheduledCardsData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.score((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.scheduleNext((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.score((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.scheduleNext((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", (dataContainer, handle) -> {
			viewProvider.reinforceCardView.add((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent", (dataContainer, handle) -> {
			viewProvider.reinforceCardView.remove((com.anfelisa.box.data.ScoreReinforceCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreReinforceCardKeepEvent", (dataContainer, handle) -> {
			viewProvider.reinforceCardView.update((com.anfelisa.box.data.ScoreReinforceCardData) dataContainer, handle);
		});
		
    }
}

/*                    S.D.G.                    */
