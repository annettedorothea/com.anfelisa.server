package com.anfelisa.category;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.category.views.CategoryView;
import com.anfelisa.category.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, AppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new CreateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetAllCategoriesAction(jdbi, appConfiguration, daoProvider, viewProvider));
	}

	public void registerConsumers(ViewProvider viewProvider, String mode) {
				viewProvider.addConsumer("com.anfelisa.category.events.CreateCategoryOkEvent", viewProvider.categoryView.insert);
				viewProvider.addConsumer("com.anfelisa.category.events.UpdateCategoryOkEvent", viewProvider.categoryView.update);
				viewProvider.addConsumer("com.anfelisa.category.events.DeleteCategoryOkEvent", viewProvider.categoryView.delete);
    }
}

/*                    S.D.G.                    */
