package com.anfelisa.setup;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.setup.views.*;
import com.anfelisa.setup.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new SetupAnfelisaResource());
	}

	public static void registerConsumers() {
		DatabaseView databaseView = new DatabaseView();
		
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createSchema);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createUserTable);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createCourseTable);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createLessonTable);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createTestTable);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createResultTable);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createStudentOfCourseTable);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createCardTable);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createBoxTable);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createCardOfBoxTable);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createStudentOfBoxTable);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createAddCardsAfterEditToBoxTable);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createAddAllCardsToBoxTable);
    }
}

/*                    S.D.G.                    */
