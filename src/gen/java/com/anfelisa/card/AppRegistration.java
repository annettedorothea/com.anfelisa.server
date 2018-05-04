package com.anfelisa.card;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.card.views.CardView;
import com.anfelisa.card.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public void registerResources(Environment environment, DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		environment.jersey().register(new CreateCardAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new UpdateCardAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new DeleteCardAction(jdbi, appConfiguration, daoProvider));
		environment.jersey().register(new GetAllCardsAction(jdbi, appConfiguration, daoProvider));
	}

	public void registerConsumers(ViewProvider viewProvider) {
				AceController.addConsumer("com.anfelisa.card.events.CreateCardOkEvent", viewProvider.cardView.insert);
				AceController.addConsumer("com.anfelisa.card.events.UpdateCardOkEvent", viewProvider.cardView.update);
				AceController.addConsumer("com.anfelisa.card.events.DeleteCardOkEvent", viewProvider.cardView.delete);
    }
}

/*                    S.D.G.                    */
