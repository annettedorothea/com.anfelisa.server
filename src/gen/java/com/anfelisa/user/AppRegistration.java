package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.user.views.*;
import com.anfelisa.user.actions.*;

public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateUserAction(jdbi));
		environment.jersey().register(new LoginAction(jdbi));
		environment.jersey().register(new GetPointsAction(jdbi));
		environment.jersey().register(new GetUserInfoAction(jdbi));
		environment.jersey().register(new UpdateUserAction(jdbi));
		environment.jersey().register(new GetCourseSelectionAction(jdbi));
		environment.jersey().register(new AddCoursesAction(jdbi));
		environment.jersey().register(new RemoveCourseAction(jdbi));
		environment.jersey().register(new UpdatePasswordAction(jdbi));
		environment.jersey().register(new ForgotPasswordAction(jdbi));
		environment.jersey().register(new RegisterUserAction(jdbi));
		environment.jersey().register(new UsernameAvailableAction(jdbi));
		environment.jersey().register(new ConfirmEmailAction(jdbi));
	}

	public static void registerConsumers() {
		UserView userView = new UserView();
		LoginLogView loginLogView = new LoginLogView();
		
		AceController.addConsumer("UserCreatedEvent", userView.createUser);
		AceController.addConsumer("UserRegisteredEvent", userView.registerUser);
		AceController.addConsumer("UserLoggedInEvent", loginLogView.userLoggedIn);
		AceController.addConsumer("UserUpdatedEvent", userView.updateUser);
		AceController.addConsumer("CoursesAddedEvent", userView.addCourses);
		AceController.addConsumer("CourseRemovedEvent", userView.removeCourse);
		AceController.addConsumer("PasswordUpdatedEvent", userView.updatePassword);
		AceController.addConsumer("SendEmailEvent", userView.sendForgotPasswordEmail);
		AceController.addConsumer("SendRegistrationEmailEvent", userView.sendRegistrationEmail);
		AceController.addConsumer("EmailConfirmedEvent", userView.confirmEmail);
    }
}

/*                    S.D.G.                    */
