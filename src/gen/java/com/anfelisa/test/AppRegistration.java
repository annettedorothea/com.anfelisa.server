package com.anfelisa.test;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.test.views.*;
import com.anfelisa.test.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateTestAction(jdbi));
		environment.jersey().register(new LoadPublicTestsAction(jdbi));
		environment.jersey().register(new LoadPublicTestAction(jdbi));
		environment.jersey().register(new LoadPrivateTestsAction(jdbi));
		environment.jersey().register(new LoadPrivateTestAction(jdbi));
		environment.jersey().register(new GetTestAction(jdbi));
		environment.jersey().register(new UpdateTestAction(jdbi));
		environment.jersey().register(new GetCardsOfTestAction(jdbi));
	}

	public static void registerConsumers() {
		TestView testView = new TestView();
		
		AceController.addConsumer("com.anfelisa.test.events.TestCreatedEvent", testView.createTest);
		AceController.addConsumer("com.anfelisa.test.events.TestUpdatedEvent", testView.updateTest);
    }
}

/*                    S.D.G.                    */
