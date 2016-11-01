package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.user.views.*;
import com.anfelisa.user.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new CreateUserResource());
	}

	public static void registerConsumers() {
		UserView userView = new UserView();
		
		AceController.addConsumer("UserCreatedEvent", userView.createUser);
    }
}

/*                    S.D.G.                    */
