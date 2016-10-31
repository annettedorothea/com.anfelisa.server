package com.anfelisa.mandator;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.mandator.views.*;
import com.anfelisa.mandator.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new CreateMandatorResource());
		environment.jersey().register(new ReadMandatorsResource());
		environment.jersey().register(new ReadMandatorHomeDataResource());
	}

	public static void registerConsumers() {
		MandatorView mandatorView = new MandatorView();
		
		AceController.addConsumer("MandatorCreatedEvent", mandatorView.createMandator);
		AceController.addConsumer("MandatorCreatedEvent", mandatorView.sendRegistrationEmail);
    }
}

/*                    S.D.G.                    */
