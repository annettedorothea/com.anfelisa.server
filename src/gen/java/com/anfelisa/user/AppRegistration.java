package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.user.views.UserView;
import com.anfelisa.user.views.ResetPasswordView;
import com.anfelisa.user.views.EmailView;
import com.anfelisa.user.views.EmailConfirmationView;
import com.anfelisa.user.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		environment.jersey().register(new GetUserProfileAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new UsernameAvailableAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new GetRoleAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new GetAllUsersAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new UpdateUserAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new ForgotPasswordAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new ResetPasswordAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new RegisterUserAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new ConfirmEmailAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new ChangeUserRoleAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new DeleteUserAction(jdbi, appConfiguration, daoProvider));
	}

	public void registerConsumers(ViewProvider viewProvider) {
				AceController.addConsumer("com.anfelisa.user.events.UpdateUserSuccessEvent", viewProvider.userView.updateUser);
				AceController.addConsumer("com.anfelisa.user.events.ForgotPasswordOkEvent", viewProvider.resetPasswordView.insert);
		if (AceController.getAceExecutionMode() == AceExecutionMode.LIVE || AceController.getAceExecutionMode() == AceExecutionMode.DEV) {
			AceController.addConsumer("com.anfelisa.user.events.ForgotPasswordOkEvent", viewProvider.emailView.sendForgotPasswordEmail);
		}
				AceController.addConsumer("com.anfelisa.user.events.ResetPasswordOkEvent", viewProvider.userView.resetPassword);
				AceController.addConsumer("com.anfelisa.user.events.ResetPasswordOkEvent", viewProvider.resetPasswordView.delete);
				AceController.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", viewProvider.userView.registerUser);
				AceController.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", viewProvider.emailConfirmationView.insert);
		if (AceController.getAceExecutionMode() == AceExecutionMode.LIVE || AceController.getAceExecutionMode() == AceExecutionMode.DEV) {
			AceController.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", viewProvider.emailView.sendRegistrationEmail);
		}
				AceController.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", viewProvider.userView.confirmEmail);
				AceController.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", viewProvider.emailConfirmationView.delete);
				AceController.addConsumer("com.anfelisa.user.events.ChangeUserRoleOkEvent", viewProvider.userView.changeUserRole);
				AceController.addConsumer("com.anfelisa.user.events.DeleteUserOkEvent", viewProvider.userView.deleteUser);
    }
}

/*                    S.D.G.                    */
