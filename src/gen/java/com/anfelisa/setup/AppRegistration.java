package com.anfelisa.setup;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.setup.views.*;
import com.anfelisa.setup.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new SetupAnfelisaResource(jdbi));
		environment.jersey().register(new SetupSchemaResource(jdbi));
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
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createBoxOfCourse);
		AceController.addConsumer("SetupAnfelisaEvent", databaseView.createLoginLog);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createSchema);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createTimelineTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createErrorTimelineTable);
    }
}

/*                    S.D.G.                    */
