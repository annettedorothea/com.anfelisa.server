package com.anfelisa.ace;

import org.jdbi.v3.core.Jdbi;

import io.dropwizard.setup.Environment;

public class AppRegistration {

	public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		com.anfelisa.user.AppRegistration.registerResources(environment, jdbi, appConfiguration, daoProvider,
				viewProvider);

		com.anfelisa.box.AppRegistration.registerResources(environment, jdbi, appConfiguration, daoProvider,
				viewProvider);

		com.anfelisa.category.AppRegistration.registerResources(environment, jdbi, appConfiguration, daoProvider,
				viewProvider);

		com.anfelisa.card.AppRegistration.registerResources(environment, jdbi, appConfiguration, daoProvider,
				viewProvider);

	}

	public static void registerConsumers(ViewProvider viewProvider, String mode) {
		com.anfelisa.user.AppRegistration.registerConsumers(viewProvider, mode);

		com.anfelisa.box.AppRegistration.registerConsumers(viewProvider, mode);

		com.anfelisa.category.AppRegistration.registerConsumers(viewProvider, mode);

		com.anfelisa.card.AppRegistration.registerConsumers(viewProvider, mode);
	}
}
