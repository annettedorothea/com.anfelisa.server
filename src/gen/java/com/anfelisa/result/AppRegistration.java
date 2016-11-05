package com.anfelisa.result;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.result.views.*;
import com.anfelisa.result.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new CreateResultResource());
	}

	public static void registerConsumers() {
		ResultView resultView = new ResultView();
		
		AceController.addConsumer("ResultCreatedEvent", resultView.createResult);
    }
}

/*                    S.D.G.                    */
