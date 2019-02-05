package com.anfelisa.card;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;
import com.anfelisa.ace.E2E;

import org.jdbi.v3.core.Jdbi;


import com.anfelisa.card.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		environment.jersey().register(new CreateCardAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new UpdateCardAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new DeleteCardAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetDuplicatesAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetTranslationAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetCardsAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new MoveCardsAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
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
		
		viewProvider.addConsumer("com.anfelisa.card.events.MoveCardsOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.moveCards((com.anfelisa.card.data.CardIdListData) dataContainer, handle);
		});
		
    }
}

/*                    S.D.G.                    */
