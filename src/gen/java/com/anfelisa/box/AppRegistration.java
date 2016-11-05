package com.anfelisa.box;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.box.views.*;
import com.anfelisa.box.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new CreateBoxResource());
		environment.jersey().register(new AddCourseToBoxResource());
		environment.jersey().register(new CreateCardResource());
		environment.jersey().register(new CreateCardOfBoxResource());
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
    }
}

/*                    S.D.G.                    */
