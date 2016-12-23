package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.user.views.*;
import com.anfelisa.user.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateUserResource(jdbi));
		environment.jersey().register(new LoginResource(jdbi));
		environment.jersey().register(new GetPointsResource(jdbi));
		environment.jersey().register(new GetUserInfoResource(jdbi));
	}

	public static void registerConsumers() {
		UserView userView = new UserView();
		LoginLogView loginLogView = new LoginLogView();
		
		AceController.addConsumer("UserCreatedEvent", userView.createUser);
		AceController.addConsumer("UserLoggedInEvent", loginLogView.userLoggedIn);
    }
}

/*                    S.D.G.                    */
