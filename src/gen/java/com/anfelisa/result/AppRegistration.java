package com.anfelisa.result;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceExecutionMode;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.result.views.ResultView;
import com.anfelisa.result.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi, DBI jdbiTimeline) {
		environment.jersey().register(new CreateResultAction(jdbi, jdbiTimeline));
		environment.jersey().register(new SaveResultAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadResultAction(jdbi, jdbiTimeline));
	}

	public static void registerConsumers() {
			AceController.addConsumer("com.anfelisa.result.events.ResultCreatedEvent", ResultView.createResult);
			AceController.addConsumer("com.anfelisa.result.events.ResultSavedEvent", ResultView.saveResult);
			AceController.addConsumer("com.anfelisa.result.events.ResultSavedEvent", ResultView.fillBoxWithCards);
    }
}

/*                    S.D.G.                    */
