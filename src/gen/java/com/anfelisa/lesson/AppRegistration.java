package com.anfelisa.lesson;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.lesson.views.*;
import com.anfelisa.lesson.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi, DBI jdbiTimeline) {
		environment.jersey().register(new CreateLessonAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadPublicLessonsAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadPrivateLessonsAction(jdbi, jdbiTimeline));
		environment.jersey().register(new GetLessonAction(jdbi, jdbiTimeline));
		environment.jersey().register(new UpdateLessonAction(jdbi, jdbiTimeline));
	}

	public static void registerConsumers() {
		LessonView lessonView = new LessonView();
		
		AceController.addConsumer("com.anfelisa.lesson.events.LessonCreatedEvent", lessonView.createLesson);
		AceController.addConsumer("com.anfelisa.lesson.events.LessonUpdatedEvent", lessonView.updateLesson);
    }
}

/*                    S.D.G.                    */
