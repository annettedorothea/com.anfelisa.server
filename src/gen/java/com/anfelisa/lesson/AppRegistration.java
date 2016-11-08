package com.anfelisa.lesson;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.lesson.views.*;
import com.anfelisa.lesson.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new CreateLessonResource());
		environment.jersey().register(new LoadPublicLessonsResource());
	}

	public static void registerConsumers() {
		LessonView lessonView = new LessonView();
		
		AceController.addConsumer("LessonCreatedEvent", lessonView.createLesson);
    }
}

/*                    S.D.G.                    */
