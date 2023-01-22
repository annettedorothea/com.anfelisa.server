package de.acegen;

import io.dropwizard.setup.Environment;

public class AppRegistration {

	public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		
		com.anfelisa.user.AppRegistration.registerResources(environment, persistenceConnection, appConfiguration, daoProvider,
				viewProvider);

		com.anfelisa.box.AppRegistration.registerResources(environment, persistenceConnection, appConfiguration, daoProvider,
				viewProvider);

		com.anfelisa.category.AppRegistration.registerResources(environment, persistenceConnection, appConfiguration, daoProvider,
				viewProvider);

		com.anfelisa.card.AppRegistration.registerResources(environment, persistenceConnection, appConfiguration, daoProvider,
				viewProvider);

	}

	public static void registerConsumers(Environment environment, ViewProvider viewProvider) {
		com.anfelisa.user.AppRegistration.registerConsumers(environment, viewProvider);

		com.anfelisa.box.AppRegistration.registerConsumers(viewProvider);

		com.anfelisa.category.AppRegistration.registerConsumers(viewProvider);

		com.anfelisa.card.AppRegistration.registerConsumers(viewProvider);
	}
}
