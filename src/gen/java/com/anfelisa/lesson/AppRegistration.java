package com.anfelisa.lesson;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.lesson.views.*;
import com.anfelisa.lesson.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateLessonResource(jdbi));
		environment.jersey().register(new LoadPublicLessonsResource(jdbi));
		environment.jersey().register(new LoadPrivateLessonsResource(jdbi));
		environment.jersey().register(new GetLessonResource(jdbi));
	}

	public static void registerConsumers() {
		LessonView lessonView = new LessonView();
		
		AceController.addConsumer("LessonCreatedEvent", lessonView.createLesson);
    }
}

/*                    S.D.G.                    */
