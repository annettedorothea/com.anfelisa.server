package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;
import com.anfelisa.ace.E2E;

import org.jdbi.v3.core.Jdbi;


import com.anfelisa.user.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		environment.jersey().register(new GetUserProfileAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new UsernameAvailableAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetRoleAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetAllUsersAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ForgotPasswordAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new SendForgotPasswordEmailAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ResetPasswordAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new RegisterUserAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new SendRegistrationEmailAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ConfirmEmailAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ChangeUserRoleAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new DeleteUserAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
	}

	public static void registerConsumers(ViewProvider viewProvider, String mode) {
		viewProvider.addConsumer("com.anfelisa.user.events.ForgotPasswordOkEvent", (dataContainer, handle) -> {
			viewProvider.resetPasswordView.insert((com.anfelisa.user.data.ForgotPasswordData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.SendForgotPasswordEmailOkEvent", (dataContainer, handle) -> {
			viewProvider.emailView.sendForgotPasswordEmail((com.anfelisa.user.data.ForgotPasswordData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ResetPasswordOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.resetPassword((com.anfelisa.user.data.ResetPasswordWithNewPasswordData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ResetPasswordOkEvent", (dataContainer, handle) -> {
			viewProvider.resetPasswordView.delete((com.anfelisa.user.data.ResetPasswordWithNewPasswordData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.registerUser((com.anfelisa.user.data.UserRegistrationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", (dataContainer, handle) -> {
			viewProvider.emailConfirmationView.insert((com.anfelisa.user.data.UserRegistrationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.SendRegistrationEmailOkEvent", (dataContainer, handle) -> {
			viewProvider.emailView.sendRegistrationEmail((com.anfelisa.user.data.UserRegistrationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.confirmEmail((com.anfelisa.user.data.ConfirmEmailData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", (dataContainer, handle) -> {
			viewProvider.emailConfirmationView.delete((com.anfelisa.user.data.ConfirmEmailData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ChangeUserRoleOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.changeUserRole((com.anfelisa.user.data.ChangeUserRoleData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.DeleteUserOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.deleteUser((com.anfelisa.user.data.DeleteUserData) dataContainer, handle);
		});
		
    }
}

/*                    S.D.G.                    */
