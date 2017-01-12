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
		environment.jersey().register(new CreateCardOfBoxAction(jdbi));
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
	}

	public static void registerConsumers() {
		BoxView boxView = new BoxView();
		BoxToCourseView boxToCourseView = new BoxToCourseView();
		CardView cardView = new CardView();
		CardOfBoxView cardOfBoxView = new CardOfBoxView();
		
		AceController.addConsumer("BoxCreatedEvent", boxView.createBox);
		AceController.addConsumer("CardCreatedEvent", cardView.createCard);
		AceController.addConsumer("CardOfBoxCreatedEvent", cardOfBoxView.createCardOfBox);
		AceController.addConsumer("CourseAddedToBoxEvent", boxToCourseView.addCourseToBox);
		AceController.addConsumer("BoxUpdatedEvent", boxView.updateBox);
		AceController.addConsumer("BoxDeletedEvent", boxView.deleteBox);
		AceController.addConsumer("BoxConfigSavedEvent", boxToCourseView.saveBoxConfig);
		AceController.addConsumer("CardScoredEvent", cardOfBoxView.score);
		AceController.addConsumer("CardImportedEvent", cardView.createCard);
		AceController.addConsumer("FillBoxWithCardsEvent", boxView.fillBoxWithCards);
		AceController.addConsumer("CardDeletedEvent", cardView.deleteCard);
    }
}

/*                    S.D.G.                    */
