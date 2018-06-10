package com.anfelisa.box;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.box.views.BoxView;
import com.anfelisa.box.views.ScheduledCardView;
import com.anfelisa.box.views.ReinforceCardView;
import com.anfelisa.box.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new GetBoxesAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetBoxAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetRootCategoriesAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new CreateBoxAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateBoxAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new PostponeCardsAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteBoxAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new LoadNextCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new LoadReinforceCardListAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScheduleNextCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScheduleCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScheduleCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScoreCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new RemoveCardFromBoxAction(jdbi, appConfiguration, daoProvider, viewProvider));
	}

	public void registerConsumers(ViewProvider viewProvider, String mode) {
				viewProvider.addConsumer("com.anfelisa.box.events.CreateBoxOkEvent", viewProvider.boxView.createBox);
				viewProvider.addConsumer("com.anfelisa.box.events.UpdateBoxOkEvent", viewProvider.boxView.updateBox);
				viewProvider.addConsumer("com.anfelisa.box.events.PostponeCardsOkEvent", viewProvider.boxView.postponeCards);
				viewProvider.addConsumer("com.anfelisa.box.events.DeleteBoxOkEvent", viewProvider.boxView.deleteBox);
				viewProvider.addConsumer("com.anfelisa.box.events.ScheduleNextCardOkEvent", viewProvider.boxView.scheduleCard);
				viewProvider.addConsumer("com.anfelisa.box.events.ScheduleCardOkEvent", viewProvider.boxView.scheduleCard);
				viewProvider.addConsumer("com.anfelisa.box.events.ScheduleCategoryOkEvent", viewProvider.boxView.scheduleCategory);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreEvent", viewProvider.scheduledCardView.score);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreEvent", viewProvider.scheduledCardView.scheduleNext);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", viewProvider.scheduledCardView.score);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", viewProvider.scheduledCardView.scheduleNext);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", viewProvider.reinforceCardView.add);
				viewProvider.addConsumer("com.anfelisa.box.events.RemoveCardFromBoxDeletedEvent", viewProvider.scheduledCardView.removeFromBox);
    }
}

/*                    S.D.G.                    */
