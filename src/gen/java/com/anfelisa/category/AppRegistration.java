package com.anfelisa.category;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.actions.CreateCategoryAction;
import com.anfelisa.category.actions.DeleteCategoryAction;
import com.anfelisa.category.actions.GetAllCategoriesAction;
import com.anfelisa.category.actions.UpdateCategoryAction;

import io.dropwizard.setup.Environment;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new CreateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetAllCategoriesAction(jdbi, appConfiguration, daoProvider, viewProvider));
	}

	public void registerConsumers(ViewProvider viewProvider, String mode) {
				viewProvider.addConsumer("com.anfelisa.category.events.CreateCategoryOkEvent", viewProvider.categoryView.insert);
				viewProvider.addConsumer("com.anfelisa.category.events.UpdateCategoryOkEvent", viewProvider.categoryView.update);
				viewProvider.addConsumer("com.anfelisa.category.events.DeleteCategoryNoRootEvent", viewProvider.categoryView.delete);
				viewProvider.addConsumer("com.anfelisa.category.events.DeleteCategoryRootEvent", viewProvider.categoryView.deleteRoot);
    }
}

/*                    S.D.G.                    */
