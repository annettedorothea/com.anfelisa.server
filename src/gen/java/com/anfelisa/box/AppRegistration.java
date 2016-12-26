package com.anfelisa.box;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.box.views.*;
import com.anfelisa.box.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateBoxResource(jdbi));
		environment.jersey().register(new AddCourseToBoxResource(jdbi));
		environment.jersey().register(new CreateCardResource(jdbi));
		environment.jersey().register(new CreateCardOfBoxResource(jdbi));
		environment.jersey().register(new LoadBoxesResource(jdbi));
		environment.jersey().register(new LoadNextCardResource(jdbi));
		environment.jersey().register(new UpdateBoxResource(jdbi));
		environment.jersey().register(new LoadBoxResource(jdbi));
		environment.jersey().register(new LoadBoxOfCourseListResource(jdbi));
		environment.jersey().register(new AddCoursesToBoxResource(jdbi));
	}

	public static void registerConsumers() {
		BoxView boxView = new BoxView();
		BoxToCourseView boxToCourseView = new BoxToCourseView();
		CardView cardView = new CardView();
		CardOfBoxView cardOfBoxView = new CardOfBoxView();
		
		AceController.addConsumer("BoxCreatedEvent", boxView.createBox);
		AceController.addConsumer("CourseAddedToBoxEvent", boxToCourseView.addCourseToBox);
		AceController.addConsumer("CardCreatedEvent", cardView.createCard);
		AceController.addConsumer("CardOfBoxCreatedEvent", cardOfBoxView.createCardOfBox);
		AceController.addConsumer("BoxUpdatedEvent", boxView.updateBox);
		AceController.addConsumer("CoursesAddedToBoxEvent", boxToCourseView.addCoursesToBox);
    }
}

/*                    S.D.G.                    */
