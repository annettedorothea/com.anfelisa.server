package com.anfelisa.user;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ServerConfiguration;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.actions.ChangeUserRoleAction;
import com.anfelisa.user.actions.ConfirmEmailAction;
import com.anfelisa.user.actions.DeleteUserAction;
import com.anfelisa.user.actions.ForgotPasswordAction;
import com.anfelisa.user.actions.GetAllUsersAction;
import com.anfelisa.user.actions.GetRoleAction;
import com.anfelisa.user.actions.GetUserProfileAction;
import com.anfelisa.user.actions.RegisterUserAction;
import com.anfelisa.user.actions.ResetPasswordAction;
import com.anfelisa.user.actions.UpdateUserAction;
import com.anfelisa.user.actions.UsernameAvailableAction;

import io.dropwizard.setup.Environment;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new GetUserProfileAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UsernameAvailableAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetRoleAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetAllUsersAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateUserAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ForgotPasswordAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ResetPasswordAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new RegisterUserAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ConfirmEmailAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ChangeUserRoleAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteUserAction(jdbi, appConfiguration, daoProvider, viewProvider));
	}

	public void registerConsumers(ViewProvider viewProvider, String mode) {
				viewProvider.addConsumer("com.anfelisa.user.events.UpdateUserSuccessEvent", viewProvider.userView.updateUser);
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
