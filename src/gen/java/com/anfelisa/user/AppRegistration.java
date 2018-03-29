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

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new GetPointsAction(jdbi));
		environment.jersey().register(new GetUserInfoAction(jdbi));
		environment.jersey().register(new GetCourseSelectionAction(jdbi));
		environment.jersey().register(new UsernameAvailableAction(jdbi));
		environment.jersey().register(new CreateUserAction(jdbi));
		environment.jersey().register(new LoginAction(jdbi));
		environment.jersey().register(new UpdateUserAction(jdbi));
		environment.jersey().register(new AddCoursesAction(jdbi));
		environment.jersey().register(new RemoveCourseAction(jdbi));
		environment.jersey().register(new UpdatePasswordAction(jdbi));
		environment.jersey().register(new ForgotPasswordAction(jdbi));
		environment.jersey().register(new RegisterUserAction(jdbi));
		environment.jersey().register(new ConfirmEmailAction(jdbi));
		environment.jersey().register(new ChangeUserToPremiumAction(jdbi));
		environment.jersey().register(new ChangeUserToAuthorAction(jdbi));
		environment.jersey().register(new ChangeUserToAdminAction(jdbi));
	}

	public static void registerConsumers() {
				AceController.addConsumer("com.anfelisa.user.events.CreateUserSuccessEvent", UserView.createUser);
				AceController.addConsumer("com.anfelisa.user.events.LoginSuccessEvent", LoginLogView.userLoggedIn);
				AceController.addConsumer("com.anfelisa.user.events.UpdateUserSuccessEvent", UserView.updateUser);
				AceController.addConsumer("com.anfelisa.user.events.AddCoursesSuccessEvent", UserView.addCourses);
				AceController.addConsumer("com.anfelisa.user.events.RemoveCourseSuccessEvent", UserView.removeCourse);
				AceController.addConsumer("com.anfelisa.user.events.UpdatePasswordSuccessEvent", UserView.updatePassword);
		if (AceController.getAceExecutionMode() == AceExecutionMode.LIVE || AceController.getAceExecutionMode() == AceExecutionMode.DEV) {
			AceController.addConsumer("com.anfelisa.user.events.ForgotPasswordOkEvent", EmailView.sendForgotPasswordEmail);
		}
				AceController.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", UserView.registerUser);
		if (AceController.getAceExecutionMode() == AceExecutionMode.LIVE || AceController.getAceExecutionMode() == AceExecutionMode.DEV) {
			AceController.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", EmailView.sendRegistrationEmail);
		}
				AceController.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", UserView.confirmEmail);
				AceController.addConsumer("com.anfelisa.user.events.ChangeUserToPremiumOkEvent", UserView.changeUserToPremium);
				AceController.addConsumer("com.anfelisa.user.events.ChangeUserToAuthorOkEvent", UserView.changeUserToAuthor);
				AceController.addConsumer("com.anfelisa.user.events.ChangeUserToAdminOkEvent", UserView.changeUserToAdmin);
    }
}

/*                    S.D.G.                    */
