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
		viewProvider.addConsumer("com.anfelisa.card.events.CreateCardOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.insert((com.anfelisa.card.data.CardCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.UpdateCardOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.update((com.anfelisa.card.data.CardUpdateData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.DeleteCardOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.delete((com.anfelisa.card.data.CardDeleteData) dataContainer, handle);
		});
		
    }
}

/*                    S.D.G.                    */
