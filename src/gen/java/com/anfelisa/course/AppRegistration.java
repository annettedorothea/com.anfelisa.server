package com.anfelisa.course;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import com.anfelisa.course.views.*;
import com.anfelisa.course.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment) {
		environment.jersey().register(new CreateCourseResource());
		environment.jersey().register(new AddStudentToCourseResource());
		environment.jersey().register(new LoadPublicCoursesResource());
	}

	public static void registerConsumers() {
		CourseView courseView = new CourseView();
		StudentOfCourseView studentOfCourseView = new StudentOfCourseView();
		
		AceController.addConsumer("CourseCreatedEvent", courseView.createCourse);
		AceController.addConsumer("StudentAddedToCourseEvent", studentOfCourseView.addStudentToCourse);
    }
}

/*                    S.D.G.                    */
