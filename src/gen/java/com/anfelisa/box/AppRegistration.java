package com.anfelisa.box;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.actions.CreateBoxAction;
import com.anfelisa.box.actions.CreateCardAction;
import com.anfelisa.box.actions.CreateScheduledCardAction;
import com.anfelisa.box.actions.CreateScoredCardAction;
import com.anfelisa.box.actions.DeleteBoxAction;
import com.anfelisa.box.actions.DeleteCardAction;
import com.anfelisa.box.actions.FillBoxWithCardsAction;
import com.anfelisa.box.actions.GetAllBoxesAction;
import com.anfelisa.box.actions.ImportCardAction;
import com.anfelisa.box.actions.LoadBoxAction;
import com.anfelisa.box.actions.LoadBoxesAction;
import com.anfelisa.box.actions.LoadNextCardAction;
import com.anfelisa.box.actions.LoadReinforceCardListAction;
import com.anfelisa.box.actions.RecalculateScheduledCardsAction;
import com.anfelisa.box.actions.RemoveCardFromBoxAction;
import com.anfelisa.box.actions.ScoreCardAction;
import com.anfelisa.box.actions.UpdateBoxAction;

import io.dropwizard.setup.Environment;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
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
