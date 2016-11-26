package com.anfelisa.course;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.course.views.*;
import com.anfelisa.course.resources.*;

public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateCourseResource(jdbi));
		environment.jersey().register(new AddStudentToCourseResource(jdbi));
		environment.jersey().register(new LoadPublicCoursesResource(jdbi));
		environment.jersey().register(new LoadPrivateCoursesResource(jdbi));
		environment.jersey().register(new LoadStatisticsResource(jdbi));
	}

	public static void registerConsumers() {
		CourseView courseView = new CourseView();
		StudentOfCourseView studentOfCourseView = new StudentOfCourseView();
		
		AceController.addConsumer("CourseCreatedEvent", courseView.createCourse);
		AceController.addConsumer("StudentAddedToCourseEvent", studentOfCourseView.addStudentToCourse);
    }
}

/*                    S.D.G.                    */
