package com.anfelisa.card;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceExecutionMode;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.card.views.CardView;
import com.anfelisa.card.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateCardAction(jdbi));
		environment.jersey().register(new UpdateCardAction(jdbi));
		environment.jersey().register(new DeleteCardAction(jdbi));
		environment.jersey().register(new GetAllCardsAction(jdbi));
	}

	public static void registerConsumers() {
				AceController.addConsumer("com.anfelisa.card.events.CreateCardOkEvent", CardView.insert);
				AceController.addConsumer("com.anfelisa.card.events.UpdateCardOkEvent", CardView.update);
				AceController.addConsumer("com.anfelisa.card.events.DeleteCardOkEvent", CardView.delete);
    }
}

/*                    S.D.G.                    */
