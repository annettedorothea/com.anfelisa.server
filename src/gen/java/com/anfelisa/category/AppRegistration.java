/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.category;

import io.dropwizard.setup.Environment;
import de.acegen.PersistenceConnection;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;

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
		environment.jersey().register(new ChangeOrderCategoryResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new InviteUserToCategoryResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetInvitedUsersResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new SearchUsernameForInvitationResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
	}
	
	public static void registerConsumers(ViewProvider viewProvider) {
		viewProvider.addConsumer("com.anfelisa.category.events.CreateCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.insert((com.anfelisa.category.data.CategoryCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.UpdateCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.update((com.anfelisa.category.data.CategoryUpdateData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.DeleteCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.delete((com.anfelisa.category.data.CategoryDeleteData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.MoveCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.moveCategory((com.anfelisa.category.data.CategoryMoveData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.ChangeOrderCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.changeOrder((com.anfelisa.category.data.CategoryChangeOrderData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.InviteUserToCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.userAccessToCategoryInvitationView.invite((com.anfelisa.category.data.UserToCategoryInvitationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.InviteUserToCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.boxInvitationView.createBox((com.anfelisa.category.data.UserToCategoryInvitationData) dataContainer, handle);
		});
		
	}
}



/******* S.D.G. *******/



