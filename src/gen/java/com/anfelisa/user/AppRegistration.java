package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceExecutionMode;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.user.views.UserView;
import com.anfelisa.user.views.LoginLogView;
import com.anfelisa.user.views.EmailView;
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
		environment.jersey().register(new ChangeUserToAuthorAction(jdbi, jdbiTimeline));
		environment.jersey().register(new ChangeUserToAdminAction(jdbi, jdbiTimeline));
	}

	public static void registerConsumers() {
			AceController.addConsumer("com.anfelisa.user.events.UserCreatedEvent", UserView.createUser);
			AceController.addConsumer("com.anfelisa.user.events.UserRegisteredEvent", UserView.registerUser);
			AceController.addConsumer("com.anfelisa.user.events.UserLoggedInEvent", LoginLogView.userLoggedIn);
			AceController.addConsumer("com.anfelisa.user.events.UserUpdatedEvent", UserView.updateUser);
			AceController.addConsumer("com.anfelisa.user.events.CoursesAddedEvent", UserView.addCourses);
			AceController.addConsumer("com.anfelisa.user.events.CourseRemovedEvent", UserView.removeCourse);
			AceController.addConsumer("com.anfelisa.user.events.PasswordUpdatedEvent", UserView.updatePassword);
		if (AceController.getAceExecutionMode() == AceExecutionMode.LIVE) {
			AceController.addConsumer("com.anfelisa.user.events.SendEmailEvent", EmailView.sendForgotPasswordEmail);
		}
		if (AceController.getAceExecutionMode() == AceExecutionMode.LIVE) {
			AceController.addConsumer("com.anfelisa.user.events.SendRegistrationEmailEvent", EmailView.sendRegistrationEmail);
		}
			AceController.addConsumer("com.anfelisa.user.events.EmailConfirmedEvent", UserView.confirmEmail);
			AceController.addConsumer("com.anfelisa.user.events.ChangeUserToPremiumEvent", UserView.changeUserToPremium);
			AceController.addConsumer("com.anfelisa.user.events.ChangeUserToAuthorEvent", UserView.changeUserToAuthor);
			AceController.addConsumer("com.anfelisa.user.events.ChangeUserToAdminEvent", UserView.changeUserToAdmin);
    }
}

/*                    S.D.G.                    */
