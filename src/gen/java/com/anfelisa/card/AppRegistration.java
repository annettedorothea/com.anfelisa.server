package com.anfelisa.card;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.actions.CreateCardAction;
import com.anfelisa.card.actions.DeleteCardAction;
import com.anfelisa.card.actions.GetDuplicatesAction;
import com.anfelisa.card.actions.UpdateCardAction;

import io.dropwizard.setup.Environment;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, AppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new CreateCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetDuplicatesAction(jdbi, appConfiguration, daoProvider, viewProvider));
	}

	public void registerConsumers(ViewProvider viewProvider, String mode) {
				viewProvider.addConsumer("com.anfelisa.card.events.CreateCardOkEvent", viewProvider.cardView.insert);
				viewProvider.addConsumer("com.anfelisa.card.events.UpdateCardOkEvent", viewProvider.cardView.update);
				viewProvider.addConsumer("com.anfelisa.card.events.DeleteCardOkEvent", viewProvider.cardView.delete);
    }
}

/*                    S.D.G.                    */
