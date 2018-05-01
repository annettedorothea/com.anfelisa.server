package com.anfelisa.category;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceExecutionMode;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.category.views.CategoryView;
import com.anfelisa.category.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateCategoryAction(jdbi));
		environment.jersey().register(new UpdateCategoryAction(jdbi));
		environment.jersey().register(new MoveCategoryAction(jdbi));
		environment.jersey().register(new DeleteCategoryAction(jdbi));
		environment.jersey().register(new GetAllCategoriesAction(jdbi));
	}

	public static void registerConsumers() {
				AceController.addConsumer("com.anfelisa.category.events.CreateCategoryOkEvent", CategoryView.insert);
				AceController.addConsumer("com.anfelisa.category.events.UpdateCategoryOkEvent", CategoryView.update);
				AceController.addConsumer("com.anfelisa.category.events.MoveCategoryOkEvent", CategoryView.move);
				AceController.addConsumer("com.anfelisa.category.events.DeleteCategoryOkEvent", CategoryView.delete);
    }
}

/*                    S.D.G.                    */
