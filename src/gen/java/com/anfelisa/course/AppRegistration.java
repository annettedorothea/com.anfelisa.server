package com.anfelisa.course;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.course.views.*;
import com.anfelisa.course.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new CreateCourseResource());
	}

	public static void registerConsumers() {
		CourseView courseView = new CourseView();
		
		AceController.addConsumer("CourseCreatedEvent", courseView.createCourse);
    }
}

/*                    S.D.G.                    */
