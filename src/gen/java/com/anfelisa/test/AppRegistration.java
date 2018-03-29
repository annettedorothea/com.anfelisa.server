package com.anfelisa.test;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceExecutionMode;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.test.views.TestView;
import com.anfelisa.test.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new LoadPublicTestsAction(jdbi));
		environment.jersey().register(new LoadPublicTestAction(jdbi));
		environment.jersey().register(new LoadPrivateTestsAction(jdbi));
		environment.jersey().register(new LoadPrivateTestAction(jdbi));
		environment.jersey().register(new GetTestAction(jdbi));
		environment.jersey().register(new GetCardsOfTestAction(jdbi));
		environment.jersey().register(new GetAllTestsAction(jdbi));
		environment.jersey().register(new CreateTestAction(jdbi));
		environment.jersey().register(new UpdateTestAction(jdbi));
		environment.jersey().register(new DeleteTestAction(jdbi));
	}

	public static void registerConsumers() {
				AceController.addConsumer("com.anfelisa.test.events.CreateTestCreatedEvent", TestView.createTest);
				AceController.addConsumer("com.anfelisa.test.events.UpdateTestUpdatedEvent", TestView.updateTest);
				AceController.addConsumer("com.anfelisa.test.events.DeleteTestDeletedEvent", TestView.deleteTest);
    }
}

/*                    S.D.G.                    */
