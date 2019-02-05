package com.anfelisa.category;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;
import com.anfelisa.ace.E2E;

import org.jdbi.v3.core.Jdbi;


import com.anfelisa.category.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		environment.jersey().register(new CreateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new UpdateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new DeleteCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new InviteUserAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new RevokeUserAccessAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetUsersWithAccessAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetCategoryTreeAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new MoveCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
	}

	public static void registerConsumers(ViewProvider viewProvider, String mode) {
		viewProvider.addConsumer("com.anfelisa.category.events.CreateCategorySubEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.insert((com.anfelisa.category.data.CategoryCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.CreateCategoryRootEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.insert((com.anfelisa.category.data.CategoryCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.CreateCategoryRootEvent", (dataContainer, handle) -> {
			viewProvider.userAccessToCategoryView.grantAccess((com.anfelisa.category.data.CategoryCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.UpdateCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.update((com.anfelisa.category.data.CategoryUpdateData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.DeleteCategoryNoRootEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.delete((com.anfelisa.category.data.CategoryDeleteData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.DeleteCategoryRootEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.deleteRoot((com.anfelisa.category.data.CategoryDeleteData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.InviteUserOkEvent", (dataContainer, handle) -> {
			viewProvider.userAccessToCategoryView.grantAccessInvitation((com.anfelisa.category.data.InviteUserData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.RevokeUserAccessOkEvent", (dataContainer, handle) -> {
			viewProvider.userAccessToCategoryView.revokeAccess((com.anfelisa.category.data.RevokeUserData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.MoveCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.moveCategory((com.anfelisa.category.data.CategoryMoveData) dataContainer, handle);
		});
		
    }
}

/*                    S.D.G.                    */
