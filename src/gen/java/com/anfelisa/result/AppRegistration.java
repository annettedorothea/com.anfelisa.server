package com.anfelisa.result;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.result.views.*;
import com.anfelisa.result.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateResultResource(jdbi));
		environment.jersey().register(new LoadResultResource(jdbi));
	}

	public static void registerConsumers() {
		ResultView resultView = new ResultView();
		
		AceController.addConsumer("ResultCreatedEvent", resultView.createResult);
    }
}

/*                    S.D.G.                    */
