/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import de.acegen.PersistenceConnection;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;

import com.anfelisa.user.resources.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new RegisterUserResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetTokenResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UsernameAvailableResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ConfirmEmailResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetUserProfileResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ForgotPasswordResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ResetPasswordResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ChangeUserRoleResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteUserResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
	}
	
	public static void registerConsumers(ViewProvider viewProvider) {
		viewProvider.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.registerUser((com.anfelisa.user.data.UserRegistrationData) dataContainer, handle);
		});
		
		viewProvider.addAfterCommitConsumer("com.anfelisa.user.events.RegisterUserOkEvent", (dataContainer, handle) -> {
			viewProvider.emailConfirmationView.insert((com.anfelisa.user.data.UserRegistrationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", (dataContainer, handle) -> {
			viewProvider.emailView.sendRegistrationEmail((com.anfelisa.user.data.UserRegistrationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.confirmEmail((com.anfelisa.user.data.ConfirmEmailData) dataContainer, handle);
		});
		
		viewProvider.addAfterCommitConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", (dataContainer, handle) -> {
			viewProvider.emailConfirmationView.delete((com.anfelisa.user.data.ConfirmEmailData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ForgotPasswordOkEvent", (dataContainer, handle) -> {
			viewProvider.resetPasswordView.insert((com.anfelisa.user.data.ForgotPasswordData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ForgotPasswordOkEvent", (dataContainer, handle) -> {
			viewProvider.emailView.sendForgotPasswordEmail((com.anfelisa.user.data.ForgotPasswordData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ResetPasswordOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.resetPassword((com.anfelisa.user.data.ResetPasswordWithNewPasswordData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ResetPasswordOkEvent", (dataContainer, handle) -> {
			viewProvider.resetPasswordView.delete((com.anfelisa.user.data.ResetPasswordWithNewPasswordData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ChangeUserRoleOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.changeUserRole((com.anfelisa.user.data.ChangeUserRoleData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.DeleteUserOkEvent", (dataContainer, handle) -> {
			viewProvider.userScheduledCardView.deleteAll((com.anfelisa.user.data.DeleteUserData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.DeleteUserOkEvent", (dataContainer, handle) -> {
			viewProvider.userReinforceCardView.deleteAll((com.anfelisa.user.data.DeleteUserData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.DeleteUserOkEvent", (dataContainer, handle) -> {
			viewProvider.userRootCategoryView.deleteAll((com.anfelisa.user.data.DeleteUserData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.DeleteUserOkEvent", (dataContainer, handle) -> {
			viewProvider.userBoxView.deleteAll((com.anfelisa.user.data.DeleteUserData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.DeleteUserOkEvent", (dataContainer, handle) -> {
			viewProvider.userUserAccessToCategoryView.delete((com.anfelisa.user.data.DeleteUserData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.DeleteUserOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.deleteUser((com.anfelisa.user.data.DeleteUserData) dataContainer, handle);
		});
		
	}
}



/******* S.D.G. *******/



