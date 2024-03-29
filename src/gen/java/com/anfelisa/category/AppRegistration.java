/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category;

import io.dropwizard.setup.Environment;
import de.acegen.PersistenceConnection;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.Data;

import com.anfelisa.category.resources.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new CreateCategoryResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateCategoryResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteCategoryResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetCategoryTreeResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new MoveCategoryResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ToggleCategoryOrderResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new InviteUserToCategoryResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetInvitedUsersResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new SearchUsernameForInvitationResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
	}
	
	public static void registerConsumers(Environment environment, ViewProvider viewProvider) {
		viewProvider.addConsumer("com.anfelisa.category.events.CreateCategoryOkEvent", (data, handle) -> {
			viewProvider.categoryView.insert((Data<com.anfelisa.category.models.CategoryCreationModel>) data, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.UpdateCategoryOkEvent", (data, handle) -> {
			viewProvider.categoryView.update((Data<com.anfelisa.category.models.CategoryUpdateModel>) data, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.DeleteCategoryOkEvent", (data, handle) -> {
			viewProvider.categoryView.delete((Data<com.anfelisa.category.models.CategoryDeleteModel>) data, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.MoveCategoryOkEvent", (data, handle) -> {
			viewProvider.categoryView.moveCategory((Data<com.anfelisa.category.models.CategoryMoveModel>) data, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.ToggleCategoryOrderOkEvent", (data, handle) -> {
			viewProvider.categoryView.toggleOrder((Data<com.anfelisa.category.models.ToggleCategoryOrderModel>) data, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.InviteUserToCategoryInsertEvent", (data, handle) -> {
			viewProvider.userAccessToCategoryInvitationView.invite((Data<com.anfelisa.category.models.UserToCategoryInvitationModel>) data, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.InviteUserToCategoryInsertEvent", (data, handle) -> {
			viewProvider.boxInvitationView.createBox((Data<com.anfelisa.category.models.UserToCategoryInvitationModel>) data, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.InviteUserToCategoryUpdateEvent", (data, handle) -> {
			viewProvider.userAccessToCategoryInvitationView.changeEditable((Data<com.anfelisa.category.models.UserToCategoryInvitationModel>) data, handle);
		});
		
		
	}
}



/******* S.D.G. *******/



