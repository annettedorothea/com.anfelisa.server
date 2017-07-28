package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.user.views.*;
import com.anfelisa.user.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi, DBI jdbiTimeline) {
		environment.jersey().register(new CreateUserAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoginAction(jdbi, jdbiTimeline));
		environment.jersey().register(new GetPointsAction(jdbi, jdbiTimeline));
		environment.jersey().register(new GetUserInfoAction(jdbi, jdbiTimeline));
		environment.jersey().register(new UpdateUserAction(jdbi, jdbiTimeline));
		environment.jersey().register(new GetCourseSelectionAction(jdbi, jdbiTimeline));
		environment.jersey().register(new AddCoursesAction(jdbi, jdbiTimeline));
		environment.jersey().register(new RemoveCourseAction(jdbi, jdbiTimeline));
		environment.jersey().register(new UpdatePasswordAction(jdbi, jdbiTimeline));
		environment.jersey().register(new ForgotPasswordAction(jdbi, jdbiTimeline));
		environment.jersey().register(new RegisterUserAction(jdbi, jdbiTimeline));
		environment.jersey().register(new UsernameAvailableAction(jdbi, jdbiTimeline));
		environment.jersey().register(new ConfirmEmailAction(jdbi, jdbiTimeline));
		environment.jersey().register(new ChangeUserToPremiumAction(jdbi, jdbiTimeline));
	}

	public static void registerConsumers() {
		UserView userView = new UserView();
		LoginLogView loginLogView = new LoginLogView();
		
		AceController.addConsumer("com.anfelisa.user.events.UserCreatedEvent", userView.createUser);
		AceController.addConsumer("com.anfelisa.user.events.UserRegisteredEvent", userView.registerUser);
		AceController.addConsumer("com.anfelisa.user.events.UserLoggedInEvent", loginLogView.userLoggedIn);
		AceController.addConsumer("com.anfelisa.user.events.UserUpdatedEvent", userView.updateUser);
		AceController.addConsumer("com.anfelisa.user.events.CoursesAddedEvent", userView.addCourses);
		AceController.addConsumer("com.anfelisa.user.events.CourseRemovedEvent", userView.removeCourse);
		AceController.addConsumer("com.anfelisa.user.events.PasswordUpdatedEvent", userView.updatePassword);
		AceController.addConsumer("com.anfelisa.user.events.SendEmailEvent", userView.sendForgotPasswordEmail);
		AceController.addConsumer("com.anfelisa.user.events.SendRegistrationEmailEvent", userView.sendRegistrationEmail);
		AceController.addConsumer("com.anfelisa.user.events.EmailConfirmedEvent", userView.confirmEmail);
		AceController.addConsumer("com.anfelisa.user.events.ChangeUserToPremiumEvent", userView.changeUserToPremium);
    }
}

/*                    S.D.G.                    */
