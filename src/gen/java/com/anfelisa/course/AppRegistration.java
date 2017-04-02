package com.anfelisa.course;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.course.views.*;
import com.anfelisa.course.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, DBI jdbi) {
		environment.jersey().register(new CreateCourseAction(jdbi));
		environment.jersey().register(new AddStudentToCourseAction(jdbi));
		environment.jersey().register(new LoadPublicCoursesAction(jdbi));
		environment.jersey().register(new LoadPrivateCoursesAction(jdbi));
		environment.jersey().register(new LoadStatisticsAction(jdbi));
		environment.jersey().register(new GetCourseAction(jdbi));
		environment.jersey().register(new UpdateCourseAction(jdbi));
	}

	public static void registerConsumers() {
		CourseView courseView = new CourseView();
		StudentOfCourseView studentOfCourseView = new StudentOfCourseView();
		
		AceController.addConsumer("CourseCreatedEvent", courseView.createCourse);
		AceController.addConsumer("StudentAddedToCourseEvent", studentOfCourseView.addStudentToCourse);
		AceController.addConsumer("CourseUpdatedEvent", courseView.updateCourse);
    }
}

/*                    S.D.G.                    */
