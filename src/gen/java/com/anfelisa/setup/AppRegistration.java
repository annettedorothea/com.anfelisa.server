package com.anfelisa.setup;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.setup.views.*;
import com.anfelisa.setup.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new SetupAnfelisaResource());
		environment.jersey().register(new SetupSchemaResource());
	}

	public static void registerConsumers() {
		DatabaseView databaseView = new DatabaseView();
		
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
		AceController.addConsumer("SetupSchemaEvent", databaseView.createSchema);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createTimelineTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createErrorTimelineTable);
    }
}

/*                    S.D.G.                    */
