package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.user.views.*;
import com.anfelisa.user.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new RegisterUserResource());
	}

	public static void registerConsumers() {
		RegistrationView registrationView = new RegistrationView();
		
		AceController.addConsumer("UserRegisteredEvent", registrationView.createNewUser);
		AceController.addConsumer("UserRegisteredEvent", registrationView.sendRegistrationEmail);
    }
}

/*                    S.D.G.                    */
