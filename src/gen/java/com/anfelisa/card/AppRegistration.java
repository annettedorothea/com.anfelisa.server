package com.anfelisa.card;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;

import org.jdbi.v3.core.Jdbi;


import com.anfelisa.card.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new CreateCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetDuplicatesAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetTranslationAction(jdbi, appConfiguration, daoProvider, viewProvider));
	}

	public static void registerConsumers(ViewProvider viewProvider, String mode) {
				viewProvider.addConsumer("com.anfelisa.card.events.CreateCardOkEvent", viewProvider.cardView.insert);
				viewProvider.addConsumer("com.anfelisa.card.events.UpdateCardOkEvent", viewProvider.cardView.update);
				viewProvider.addConsumer("com.anfelisa.card.events.DeleteCardOkEvent", viewProvider.cardView.delete);
    }
}

/*                    S.D.G.                    */
