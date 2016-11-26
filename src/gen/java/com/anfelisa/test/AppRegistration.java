package com.anfelisa.test;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.test.views.*;
import com.anfelisa.test.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateTestResource(jdbi));
		environment.jersey().register(new LoadPublicTestsResource(jdbi));
		environment.jersey().register(new LoadPublicTestResource(jdbi));
		environment.jersey().register(new LoadPrivateTestsResource(jdbi));
		environment.jersey().register(new LoadPrivateTestResource(jdbi));
	}

	public static void registerConsumers() {
		TestView testView = new TestView();
		
		AceController.addConsumer("TestCreatedEvent", testView.createTest);
    }
}

/*                    S.D.G.                    */
