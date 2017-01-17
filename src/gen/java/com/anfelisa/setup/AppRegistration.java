package com.anfelisa.setup;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.setup.views.*;
import com.anfelisa.setup.actions.*;

public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateSchemaAction(jdbi));
		environment.jersey().register(new SetupSchemaAction(jdbi));
	}

	public static void registerConsumers() {
		DatabaseView databaseView = new DatabaseView();
		
		AceController.addConsumer("SetupSchemaEvent", databaseView.createUserTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createCourseTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createLessonTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createTestTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createResultTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createStudentOfCourseTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createCardTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createBoxTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createScheduledCardTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createScoredCardDaoTable);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createBoxOfCourse);
		AceController.addConsumer("SetupSchemaEvent", databaseView.createLoginLog);
		AceController.addConsumer("SetupSchemaEvent", databaseView.insertAdminUser);
		AceController.addConsumer("CreateSchemaEvent", databaseView.createSchema);
		AceController.addConsumer("CreateSchemaEvent", databaseView.createTimelineTable);
		AceController.addConsumer("CreateSchemaEvent", databaseView.createErrorTimelineTable);
    }
}

/*                    S.D.G.                    */
