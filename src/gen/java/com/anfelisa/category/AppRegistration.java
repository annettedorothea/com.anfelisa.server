package com.anfelisa.category;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;

import org.jdbi.v3.core.Jdbi;


import com.anfelisa.category.views.CategoryView;
import com.anfelisa.category.views.UserAccessToCategoryView;
import com.anfelisa.category.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new CreateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetAllCategoriesAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new InviteUserAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new RevokeUserAccessAction(jdbi, appConfiguration, daoProvider, viewProvider));
	}

	public void registerConsumers(ViewProvider viewProvider, String mode) {
				viewProvider.addConsumer("com.anfelisa.category.events.CreateCategorySubEvent", viewProvider.categoryView.insert);
				viewProvider.addConsumer("com.anfelisa.category.events.CreateCategoryRootEvent", viewProvider.categoryView.insert);
				viewProvider.addConsumer("com.anfelisa.category.events.CreateCategoryRootEvent", viewProvider.userAccessToCategoryView.grantAccess);
				viewProvider.addConsumer("com.anfelisa.category.events.UpdateCategoryOkEvent", viewProvider.categoryView.update);
				viewProvider.addConsumer("com.anfelisa.category.events.DeleteCategoryNoRootEvent", viewProvider.categoryView.delete);
				viewProvider.addConsumer("com.anfelisa.category.events.DeleteCategoryRootEvent", viewProvider.categoryView.deleteRoot);
				viewProvider.addConsumer("com.anfelisa.category.events.InviteUserOkEvent", viewProvider.userAccessToCategoryView.grantAccessInvitation);
				viewProvider.addConsumer("com.anfelisa.category.events.RevokeUserAccessOkEvent", viewProvider.userAccessToCategoryView.revokeAccess);
    }
}

/*                    S.D.G.                    */
