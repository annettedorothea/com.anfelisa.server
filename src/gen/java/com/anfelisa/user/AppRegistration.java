package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;

import org.jdbi.v3.core.Jdbi;


import com.anfelisa.user.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new GetUserProfileAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UsernameAvailableAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetRoleAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetAllUsersAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ForgotPasswordAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ResetPasswordAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new RegisterUserAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ConfirmEmailAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ChangeUserRoleAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteUserAction(jdbi, appConfiguration, daoProvider, viewProvider));
	}

	public static void registerConsumers(ViewProvider viewProvider, String mode) {
				viewProvider.addConsumer("com.anfelisa.user.events.ForgotPasswordOkEvent", viewProvider.resetPasswordView.insert);
		if (ServerConfiguration.LIVE.equals(mode) || ServerConfiguration.DEV.equals(mode)) {
		viewProvider.addConsumer("com.anfelisa.user.events.ForgotPasswordOkEvent", viewProvider.emailView.sendForgotPasswordEmail);
		}
				viewProvider.addConsumer("com.anfelisa.user.events.ResetPasswordOkEvent", viewProvider.userView.resetPassword);
				viewProvider.addConsumer("com.anfelisa.user.events.ResetPasswordOkEvent", viewProvider.resetPasswordView.delete);
				viewProvider.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", viewProvider.userView.registerUser);
				viewProvider.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", viewProvider.emailConfirmationView.insert);
		if (ServerConfiguration.LIVE.equals(mode) || ServerConfiguration.DEV.equals(mode)) {
		viewProvider.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", viewProvider.emailView.sendRegistrationEmail);
		}
				viewProvider.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", viewProvider.userView.confirmEmail);
				viewProvider.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", viewProvider.emailConfirmationView.delete);
				viewProvider.addConsumer("com.anfelisa.user.events.ChangeUserRoleOkEvent", viewProvider.userView.changeUserRole);
				viewProvider.addConsumer("com.anfelisa.user.events.DeleteUserOkEvent", viewProvider.userView.deleteUser);
    }
}

/*                    S.D.G.                    */
