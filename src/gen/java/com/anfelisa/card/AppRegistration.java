package com.anfelisa.card;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.card.views.CardView;
import com.anfelisa.card.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new CreateCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteCardAction(jdbi, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetAllCardsAction(jdbi, appConfiguration, daoProvider, viewProvider));
	}

	public void registerConsumers(ViewProvider viewProvider, String mode) {
				viewProvider.addConsumer("com.anfelisa.card.events.CreateCardOkEvent", viewProvider.cardView.insert);
				viewProvider.addConsumer("com.anfelisa.card.events.UpdateCardOkEvent", viewProvider.cardView.update);
				viewProvider.addConsumer("com.anfelisa.card.events.DeleteCardOkEvent", viewProvider.cardView.delete);
    }
}

/*                    S.D.G.                    */
