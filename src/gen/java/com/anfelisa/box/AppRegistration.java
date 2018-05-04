package com.anfelisa.box;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.box.views.BoxView;
import com.anfelisa.box.views.ScheduledCardView;
import com.anfelisa.box.views.ScoredCardView;
import com.anfelisa.box.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new LoadBoxesAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new LoadNextCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new LoadBoxAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetAllBoxesAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new LoadReinforceCardListAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new CreateBoxAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new CreateCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ImportCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new CreateScheduledCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new CreateScoredCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateBoxAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteBoxAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScoreCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new FillBoxWithCardsAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new RemoveCardFromBoxAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new RecalculateScheduledCardsAction(jdbi, appConfiguration, daoProvider, viewProvider));
	}

	public void registerConsumers(ViewProvider viewProvider, String mode) {
				viewProvider.addConsumer("com.anfelisa.box.events.CreateBoxCreatedEvent", viewProvider.boxView.createBox);
				viewProvider.addConsumer("com.anfelisa.box.events.CreateScheduledCardCreatedEvent", viewProvider.scheduledCardView.createScheduledCard);
				viewProvider.addConsumer("com.anfelisa.box.events.CreateScoredCardCreatedEvent", viewProvider.scoredCardView.createScoredCard);
				viewProvider.addConsumer("com.anfelisa.box.events.UpdateBoxUpdatedEvent", viewProvider.boxView.updateBox);
				viewProvider.addConsumer("com.anfelisa.box.events.DeleteBoxDeletedEvent", viewProvider.boxView.deleteBox);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoredEvent", viewProvider.scoredCardView.score);
				viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoredEvent", viewProvider.scheduledCardView.score);
				viewProvider.addConsumer("com.anfelisa.box.events.FillBoxWithCardsFillBoxWithCardsEvent", viewProvider.boxView.fillBoxWithCards);
				viewProvider.addConsumer("com.anfelisa.box.events.RemoveCardFromBoxDeletedEvent", viewProvider.scheduledCardView.removeFromBox);
				viewProvider.addConsumer("com.anfelisa.box.events.RecalculateScheduledCardsOkEvent", viewProvider.scheduledCardView.recalculateScheduledCards);
    }
}

/*                    S.D.G.                    */
