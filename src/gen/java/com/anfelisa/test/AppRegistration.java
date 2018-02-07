package com.anfelisa.test;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceExecutionMode;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.test.views.TestView;
import com.anfelisa.test.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi, DBI jdbiTimeline) {
		environment.jersey().register(new CreateTestAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadPublicTestsAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadPublicTestAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadPrivateTestsAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadPrivateTestAction(jdbi, jdbiTimeline));
		environment.jersey().register(new GetTestAction(jdbi, jdbiTimeline));
		environment.jersey().register(new UpdateTestAction(jdbi, jdbiTimeline));
		environment.jersey().register(new GetCardsOfTestAction(jdbi, jdbiTimeline));
		environment.jersey().register(new GetAllTestsAction(jdbi, jdbiTimeline));
		environment.jersey().register(new DeleteTestAction(jdbi, jdbiTimeline));
	}

	public static void registerConsumers() {
			AceController.addConsumer("com.anfelisa.test.events.TestCreatedEvent", TestView.createTest);
			AceController.addConsumer("com.anfelisa.test.events.TestUpdatedEvent", TestView.updateTest);
			AceController.addConsumer("com.anfelisa.test.events.TestDeletedEvent", TestView.deleteTest);
    }
}

/*                    S.D.G.                    */
