package com.anfelisa.category;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.category.views.CategoryView;
import com.anfelisa.category.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		environment.jersey().register(new CreateCategoryAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new UpdateCategoryAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new DeleteCategoryAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new GetAllCategoriesAction(jdbi, appConfiguration, daoProvider));
	}

	public void registerConsumers(ViewProvider viewProvider) {
				AceController.addConsumer("com.anfelisa.category.events.CreateCategoryOkEvent", viewProvider.categoryView.insert);
				AceController.addConsumer("com.anfelisa.category.events.UpdateCategoryOkEvent", viewProvider.categoryView.update);
				AceController.addConsumer("com.anfelisa.category.events.DeleteCategoryOkEvent", viewProvider.categoryView.delete);
    }
}

/*                    S.D.G.                    */
