package com.anfelisa.box;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.box.views.*;
import com.anfelisa.box.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi, DBI jdbiTimeline) {
		environment.jersey().register(new CreateBoxAction(jdbi, jdbiTimeline));
		environment.jersey().register(new CreateCardAction(jdbi, jdbiTimeline));
		environment.jersey().register(new ImportCardAction(jdbi, jdbiTimeline));
		environment.jersey().register(new CreateScheduledCardAction(jdbi, jdbiTimeline));
		environment.jersey().register(new CreateScoredCardAction(jdbi, jdbiTimeline));
		environment.jersey().register(new AddCourseToBoxAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadBoxesAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadNextCardAction(jdbi, jdbiTimeline));
		environment.jersey().register(new UpdateBoxAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadBoxAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadBoxOfCourseListAction(jdbi, jdbiTimeline));
		environment.jersey().register(new DeleteBoxAction(jdbi, jdbiTimeline));
		environment.jersey().register(new SaveBoxConfigAction(jdbi, jdbiTimeline));
		environment.jersey().register(new ScoreCardAction(jdbi, jdbiTimeline));
		environment.jersey().register(new FillBoxWithCardsAction(jdbi, jdbiTimeline));
		environment.jersey().register(new DeleteCardAction(jdbi, jdbiTimeline));
		environment.jersey().register(new GetAllBoxesAction(jdbi, jdbiTimeline));
		environment.jersey().register(new RemoveCardFromBoxAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadReinforceCardListAction(jdbi, jdbiTimeline));
		environment.jersey().register(new RecalculateScheduledCardsAction(jdbi, jdbiTimeline));
	}

	public static void registerConsumers() {
		BoxView boxView = new BoxView();
		BoxToCourseView boxToCourseView = new BoxToCourseView();
		CardView cardView = new CardView();
		ScheduledCardView scheduledCardView = new ScheduledCardView();
		ScoredCardView scoredCardView = new ScoredCardView();
		
		AceController.addConsumer("com.anfelisa.box.events.BoxCreatedEvent", boxView.createBox);
		AceController.addConsumer("com.anfelisa.box.events.CardCreatedEvent", cardView.createCard);
		AceController.addConsumer("com.anfelisa.box.events.ScheduledCardCreatedEvent", scheduledCardView.createScheduledCard);
		AceController.addConsumer("com.anfelisa.box.events.ScoredCardCreatedEvent", scoredCardView.createScoredCard);
		AceController.addConsumer("com.anfelisa.box.events.CourseAddedToBoxEvent", boxToCourseView.addCourseToBox);
		AceController.addConsumer("com.anfelisa.box.events.BoxUpdatedEvent", boxView.updateBox);
		AceController.addConsumer("com.anfelisa.box.events.BoxDeletedEvent", boxView.deleteBox);
		AceController.addConsumer("com.anfelisa.box.events.BoxConfigSavedEvent", boxToCourseView.saveBoxConfig);
		AceController.addConsumer("com.anfelisa.box.events.CardScoredEvent", scoredCardView.score);
		AceController.addConsumer("com.anfelisa.box.events.CardScoredEvent", scheduledCardView.score);
		AceController.addConsumer("com.anfelisa.box.events.CardImportedEvent", cardView.createCard);
		AceController.addConsumer("com.anfelisa.box.events.FillBoxWithCardsEvent", boxView.fillBoxWithCards);
		AceController.addConsumer("com.anfelisa.box.events.CardDeletedEvent", cardView.deleteCard);
		AceController.addConsumer("com.anfelisa.box.events.CardRemovedFromBoxEvent", scheduledCardView.removeFromBox);
		AceController.addConsumer("com.anfelisa.box.events.RecalculateScheduledCardsEvent", scheduledCardView.recalculateScheduledCards);
    }
}

/*                    S.D.G.                    */
