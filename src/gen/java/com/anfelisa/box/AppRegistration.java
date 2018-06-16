package com.anfelisa.box;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.actions.CreateBoxAction;
import com.anfelisa.box.actions.DeleteBoxAction;
import com.anfelisa.box.actions.GetBoxAction;
import com.anfelisa.box.actions.GetBoxesAction;
import com.anfelisa.box.actions.GetRootCategoriesAction;
import com.anfelisa.box.actions.LoadNextCardAction;
import com.anfelisa.box.actions.LoadNextReinforceCardAction;
import com.anfelisa.box.actions.PostponeCardsAction;
import com.anfelisa.box.actions.ScheduleCardAction;
import com.anfelisa.box.actions.ScheduleCategoryAction;
import com.anfelisa.box.actions.ScheduleNextCardAction;
import com.anfelisa.box.actions.ScoreCardAction;
import com.anfelisa.box.actions.ScoreReinforceCardAction;
import com.anfelisa.box.actions.UpdateBoxAction;

import io.dropwizard.setup.Environment;

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
		environment.jersey().register(new LoadNextReinforceCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScheduleNextCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScheduleCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScheduleCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScoreCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScoreReinforceCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
	}

	public void registerConsumers(ViewProvider viewProvider, String mode) {
				viewProvider.addConsumer("com.anfelisa.box.events.CreateBoxOkEvent", viewProvider.boxView.createBox);
				viewProvider.addConsumer("com.anfelisa.box.events.UpdateBoxOkEvent", viewProvider.boxView.updateBox);
				viewProvider.addConsumer("com.anfelisa.box.events.PostponeCardsOkEvent", viewProvider.scheduledCardView.postponeCards);
				viewProvider.addConsumer("com.anfelisa.box.events.DeleteBoxOkEvent", viewProvider.boxView.deleteBox);
				viewProvider.addConsumer("com.anfelisa.box.events.ScheduleNextCardOkEvent", viewProvider.boxView.scheduleCard);
				viewProvider.addConsumer("com.anfelisa.box.events.ScheduleCardOkEvent", viewProvider.boxView.scheduleCard);
				viewProvider.addConsumer("com.anfelisa.box.events.ScheduleCategoryOkEvent", viewProvider.boxView.scheduleCategory);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreEvent", viewProvider.scheduledCardView.score);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreEvent", viewProvider.scheduledCardView.scheduleNext);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", viewProvider.scheduledCardView.score);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", viewProvider.scheduledCardView.scheduleNext);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", viewProvider.reinforceCardView.add);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent", viewProvider.reinforceCardView.remove);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreReinforceCardKeepEvent", viewProvider.reinforceCardView.update);
    }
}

/*                    S.D.G.                    */
