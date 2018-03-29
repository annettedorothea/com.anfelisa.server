package com.anfelisa.box;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceExecutionMode;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.box.views.BoxView;
import com.anfelisa.box.views.CardView;
import com.anfelisa.box.views.ScheduledCardView;
import com.anfelisa.box.views.ScoredCardView;
import com.anfelisa.box.views.BoxToCourseView;
import com.anfelisa.box.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new LoadBoxesAction(jdbi));
		environment.jersey().register(new LoadNextCardAction(jdbi));
		environment.jersey().register(new LoadBoxAction(jdbi));
		environment.jersey().register(new LoadBoxOfCourseListAction(jdbi));
		environment.jersey().register(new GetAllBoxesAction(jdbi));
		environment.jersey().register(new LoadReinforceCardListAction(jdbi));
		environment.jersey().register(new CreateBoxAction(jdbi));
		environment.jersey().register(new CreateCardAction(jdbi));
		environment.jersey().register(new ImportCardAction(jdbi));
		environment.jersey().register(new CreateScheduledCardAction(jdbi));
		environment.jersey().register(new CreateScoredCardAction(jdbi));
		environment.jersey().register(new AddCourseToBoxAction(jdbi));
		environment.jersey().register(new UpdateBoxAction(jdbi));
		environment.jersey().register(new DeleteBoxAction(jdbi));
		environment.jersey().register(new SaveBoxConfigAction(jdbi));
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
				AceController.addConsumer("com.anfelisa.box.events.AddCourseToBoxAddedEvent", BoxToCourseView.addCourseToBox);
				AceController.addConsumer("com.anfelisa.box.events.UpdateBoxUpdatedEvent", BoxView.updateBox);
				AceController.addConsumer("com.anfelisa.box.events.DeleteBoxDeletedEvent", BoxView.deleteBox);
				AceController.addConsumer("com.anfelisa.box.events.SaveBoxConfigSavedEvent", BoxToCourseView.saveBoxConfig);
				AceController.addConsumer("com.anfelisa.box.events.ScoreCardScoredEvent", ScoredCardView.score);
				AceController.addConsumer("com.anfelisa.box.events.ScoreCardScoredEvent", ScheduledCardView.score);
				AceController.addConsumer("com.anfelisa.box.events.FillBoxWithCardsFillBoxWithCardsEvent", BoxView.fillBoxWithCards);
				AceController.addConsumer("com.anfelisa.box.events.DeleteCardDeletedEvent", CardView.deleteCard);
				AceController.addConsumer("com.anfelisa.box.events.RemoveCardFromBoxDeletedEvent", ScheduledCardView.removeFromBox);
				AceController.addConsumer("com.anfelisa.box.events.RecalculateScheduledCardsOkEvent", ScheduledCardView.recalculateScheduledCards);
    }
}

/*                    S.D.G.                    */
