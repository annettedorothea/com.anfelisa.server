package com.anfelisa.result;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.result.views.*;
import com.anfelisa.result.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateResultAction(jdbi));
		environment.jersey().register(new SaveResultAction(jdbi));
		environment.jersey().register(new LoadResultAction(jdbi));
	}

	public static void registerConsumers() {
		ResultView resultView = new ResultView();
		
		AceController.addConsumer("com.anfelisa.result.events.ResultCreatedEvent", resultView.createResult);
		AceController.addConsumer("com.anfelisa.result.events.ResultSavedEvent", resultView.saveResult);
		AceController.addConsumer("com.anfelisa.result.events.ResultSavedEvent", resultView.fillBoxWithCards);
    }
}

/*                    S.D.G.                    */
