package com.anfelisa.box;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.AceController;
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
import com.anfelisa.box.views.BoxView;
import com.anfelisa.box.views.CardView;
import com.anfelisa.box.views.ScheduledCardView;
import com.anfelisa.box.views.ScoredCardView;

import io.dropwizard.setup.Environment;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new LoadBoxesAction(jdbi));
		environment.jersey().register(new LoadNextCardAction(jdbi));
		environment.jersey().register(new LoadBoxAction(jdbi));
		environment.jersey().register(new GetAllBoxesAction(jdbi));
		environment.jersey().register(new LoadReinforceCardListAction(jdbi));
		environment.jersey().register(new CreateBoxAction(jdbi));
		environment.jersey().register(new CreateCardAction(jdbi));
		environment.jersey().register(new ImportCardAction(jdbi));
		environment.jersey().register(new CreateScheduledCardAction(jdbi));
		environment.jersey().register(new CreateScoredCardAction(jdbi));
		environment.jersey().register(new UpdateBoxAction(jdbi));
		environment.jersey().register(new DeleteBoxAction(jdbi));
		environment.jersey().register(new ScoreCardAction(jdbi));
		environment.jersey().register(new FillBoxWithCardsAction(jdbi));
		environment.jersey().register(new DeleteCardAction(jdbi));
		environment.jersey().register(new RemoveCardFromBoxAction(jdbi));
		environment.jersey().register(new RecalculateScheduledCardsAction(jdbi));
	}

	public static void registerConsumers() {
				AceController.addConsumer("com.anfelisa.box.events.CreateBoxCreatedEvent", BoxView.createBox);
				AceController.addConsumer("com.anfelisa.box.events.CreateCardCreatedEvent", CardView.createCard);
				AceController.addConsumer("com.anfelisa.box.events.ImportCardImportedEvent", CardView.createCard);
				AceController.addConsumer("com.anfelisa.box.events.CreateScheduledCardCreatedEvent", ScheduledCardView.createScheduledCard);
				AceController.addConsumer("com.anfelisa.box.events.CreateScoredCardCreatedEvent", ScoredCardView.createScoredCard);
				AceController.addConsumer("com.anfelisa.box.events.UpdateBoxUpdatedEvent", BoxView.updateBox);
				AceController.addConsumer("com.anfelisa.box.events.DeleteBoxDeletedEvent", BoxView.deleteBox);
				AceController.addConsumer("com.anfelisa.box.events.ScoreCardScoredEvent", ScoredCardView.score);
				AceController.addConsumer("com.anfelisa.box.events.ScoreCardScoredEvent", ScheduledCardView.score);
				AceController.addConsumer("com.anfelisa.box.events.FillBoxWithCardsFillBoxWithCardsEvent", BoxView.fillBoxWithCards);
				AceController.addConsumer("com.anfelisa.box.events.DeleteCardDeletedEvent", CardView.deleteCard);
				AceController.addConsumer("com.anfelisa.box.events.RemoveCardFromBoxDeletedEvent", ScheduledCardView.removeFromBox);
				AceController.addConsumer("com.anfelisa.box.events.RecalculateScheduledCardsOkEvent", ScheduledCardView.recalculateScheduledCards);
    }
}

/*                    S.D.G.                    */
