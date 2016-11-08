package com.anfelisa.test;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.test.views.*;
import com.anfelisa.test.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new CreateTestResource());
		environment.jersey().register(new LoadPublicTestsResource());
		environment.jersey().register(new LoadPublicTestResource());
	}

	public static void registerConsumers() {
		TestView testView = new TestView();
		
		AceController.addConsumer("TestCreatedEvent", testView.createTest);
    }
}

/*                    S.D.G.                    */
