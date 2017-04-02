package com.anfelisa.lesson;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.lesson.views.*;
import com.anfelisa.lesson.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateLessonAction(jdbi));
		environment.jersey().register(new LoadPublicLessonsAction(jdbi));
		environment.jersey().register(new LoadPrivateLessonsAction(jdbi));
		environment.jersey().register(new GetLessonAction(jdbi));
		environment.jersey().register(new UpdateLessonAction(jdbi));
	}

	public static void registerConsumers() {
		LessonView lessonView = new LessonView();
		
		AceController.addConsumer("LessonCreatedEvent", lessonView.createLesson);
		AceController.addConsumer("LessonUpdatedEvent", lessonView.updateLesson);
    }
}

/*                    S.D.G.                    */
