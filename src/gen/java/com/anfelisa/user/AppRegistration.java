/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.user;

import io.dropwizard.setup.Environment;
import de.acegen.PersistenceConnection;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.E2E;
import de.acegen.ViewProvider;

import com.anfelisa.user.resources.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		environment.jersey().register(new RegisterUserResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetRoleResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new UsernameAvailableResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ConfirmEmailResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetUserProfileResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetAllUsersResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ForgotPasswordResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ResetPasswordResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ChangeUserRoleResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new DeleteUserResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
	}
	
	public static void registerConsumers(ViewProvider viewProvider, String mode) {
		viewProvider.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.registerUser((com.anfelisa.user.data.UserRegistrationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", (dataContainer, handle) -> {
			viewProvider.emailConfirmationView.insert((com.anfelisa.user.data.UserRegistrationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.RegisterUserOkEvent", (dataContainer, handle) -> {
			viewProvider.emailView.sendRegistrationEmail((com.anfelisa.user.data.UserRegistrationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", (dataContainer, handle) -> {
			viewProvider.userView.confirmEmail((com.anfelisa.user.data.ConfirmEmailData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.user.events.ConfirmEmailOkEvent", (dataContainer, handle) -> {
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



