package com.anfelisa.lesson;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceExecutionMode;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.lesson.views.LessonView;
import com.anfelisa.lesson.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi, DBI jdbiTimeline) {
		environment.jersey().register(new CreateLessonAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadPublicLessonsAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadPrivateLessonsAction(jdbi, jdbiTimeline));
		environment.jersey().register(new GetLessonAction(jdbi, jdbiTimeline));
		environment.jersey().register(new UpdateLessonAction(jdbi, jdbiTimeline));
		environment.jersey().register(new GetAllLessonsAction(jdbi, jdbiTimeline));
		environment.jersey().register(new DeleteLessonAction(jdbi, jdbiTimeline));
	}

	public static void registerConsumers() {
			AceController.addConsumer("com.anfelisa.lesson.events.LessonCreatedEvent", LessonView.createLesson);
			AceController.addConsumer("com.anfelisa.lesson.events.LessonUpdatedEvent", LessonView.updateLesson);
			AceController.addConsumer("com.anfelisa.lesson.events.LessonDeletedEvent", LessonView.deleteLesson);
    }
}

/*                    S.D.G.                    */
