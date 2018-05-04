package com.anfelisa.box;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.box.views.BoxView;
import com.anfelisa.box.views.ScheduledCardView;
import com.anfelisa.box.views.ScoredCardView;
import com.anfelisa.box.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		environment.jersey().register(new LoadBoxesAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new LoadNextCardAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new LoadBoxAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new GetAllBoxesAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new LoadReinforceCardListAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new CreateBoxAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new CreateCardAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new ImportCardAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new CreateScheduledCardAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new CreateScoredCardAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new UpdateBoxAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new DeleteBoxAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new ScoreCardAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new FillBoxWithCardsAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new DeleteCardAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new RemoveCardFromBoxAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new RecalculateScheduledCardsAction(jdbi, appConfiguration, daoProvider));
	}

	public void registerConsumers(ViewProvider viewProvider) {
				AceController.addConsumer("com.anfelisa.box.events.CreateBoxCreatedEvent", viewProvider.boxView.createBox);
				AceController.addConsumer("com.anfelisa.box.events.CreateScheduledCardCreatedEvent", viewProvider.scheduledCardView.createScheduledCard);
				AceController.addConsumer("com.anfelisa.box.events.CreateScoredCardCreatedEvent", viewProvider.scoredCardView.createScoredCard);
				AceController.addConsumer("com.anfelisa.box.events.UpdateBoxUpdatedEvent", viewProvider.boxView.updateBox);
				AceController.addConsumer("com.anfelisa.box.events.DeleteBoxDeletedEvent", viewProvider.boxView.deleteBox);
				AceController.addConsumer("com.anfelisa.box.events.ScoreCardScoredEvent", viewProvider.scoredCardView.score);
				AceController.addConsumer("com.anfelisa.box.events.ScoreCardScoredEvent", viewProvider.scheduledCardView.score);
				AceController.addConsumer("com.anfelisa.box.events.FillBoxWithCardsFillBoxWithCardsEvent", viewProvider.boxView.fillBoxWithCards);
				AceController.addConsumer("com.anfelisa.box.events.RemoveCardFromBoxDeletedEvent", viewProvider.scheduledCardView.removeFromBox);
				AceController.addConsumer("com.anfelisa.box.events.RecalculateScheduledCardsOkEvent", viewProvider.scheduledCardView.recalculateScheduledCards);
    }
}

/*                    S.D.G.                    */
