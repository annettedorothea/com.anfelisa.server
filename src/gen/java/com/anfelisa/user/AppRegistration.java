package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.user.views.*;
import com.anfelisa.user.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new CreateUserResource());
		environment.jersey().register(new LoginResource());
		environment.jersey().register(new GetPointsResource());
	}

	public static void registerConsumers() {
		UserView userView = new UserView();
		LoginLogView loginLogView = new LoginLogView();
		
		AceController.addConsumer("UserCreatedEvent", userView.createUser);
		AceController.addConsumer("UserLoggedInEvent", loginLogView.userLoggedIn);
    }
}

/*                    S.D.G.                    */
