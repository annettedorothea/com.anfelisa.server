package com.anfelisa.box;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.box.views.*;
import com.anfelisa.box.actions.*;

public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateBoxAction(jdbi));
		environment.jersey().register(new CreateCardAction(jdbi));
		environment.jersey().register(new ImportCardAction(jdbi));
		environment.jersey().register(new CreateScheduledCardAction(jdbi));
		environment.jersey().register(new CreateScoredCardAction(jdbi));
		environment.jersey().register(new AddCourseToBoxAction(jdbi));
		environment.jersey().register(new LoadBoxesAction(jdbi));
		environment.jersey().register(new LoadNextCardAction(jdbi));
		environment.jersey().register(new UpdateBoxAction(jdbi));
		environment.jersey().register(new LoadBoxAction(jdbi));
		environment.jersey().register(new LoadBoxOfCourseListAction(jdbi));
		environment.jersey().register(new DeleteBoxAction(jdbi));
		environment.jersey().register(new SaveBoxConfigAction(jdbi));
		environment.jersey().register(new ScoreCardAction(jdbi));
		environment.jersey().register(new FillBoxWithCardsAction(jdbi));
		environment.jersey().register(new DeleteCardAction(jdbi));
		environment.jersey().register(new GetAllBoxesAction(jdbi));
		environment.jersey().register(new RemoveCardFromBoxAction(jdbi));
		environment.jersey().register(new LoadReinforceCardListAction(jdbi));
	}

	public static void registerConsumers() {
		BoxView boxView = new BoxView();
		BoxToCourseView boxToCourseView = new BoxToCourseView();
		CardView cardView = new CardView();
		ScheduledCardView scheduledCardView = new ScheduledCardView();
		ScoredCardView scoredCardView = new ScoredCardView();
		
		AceController.addConsumer("BoxCreatedEvent", boxView.createBox);
		AceController.addConsumer("CardCreatedEvent", cardView.createCard);
		AceController.addConsumer("ScheduledCardCreatedEvent", scheduledCardView.createScheduledCard);
		AceController.addConsumer("ScoredCardCreatedEvent", scoredCardView.createScoredCard);
		AceController.addConsumer("CourseAddedToBoxEvent", boxToCourseView.addCourseToBox);
		AceController.addConsumer("BoxUpdatedEvent", boxView.updateBox);
		AceController.addConsumer("BoxDeletedEvent", boxView.deleteBox);
		AceController.addConsumer("BoxConfigSavedEvent", boxToCourseView.saveBoxConfig);
		AceController.addConsumer("CardScoredEvent", scoredCardView.score);
		AceController.addConsumer("CardScoredEvent", scheduledCardView.score);
		AceController.addConsumer("CardImportedEvent", cardView.createCard);
		AceController.addConsumer("FillBoxWithCardsEvent", boxView.fillBoxWithCards);
		AceController.addConsumer("CardDeletedEvent", cardView.deleteCard);
		AceController.addConsumer("CardRemovedFromBoxEvent", scheduledCardView.removeFromBox);
    }
}

/*                    S.D.G.                    */
