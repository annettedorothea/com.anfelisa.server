package com.anfelisa.course;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.AceController;
import com.anfelisa.ace.AceExecutionMode;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.course.views.CourseView;
import com.anfelisa.course.views.StudentOfCourseView;
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
		environment.jersey().register(new DeleteCourseAction(jdbi));
		environment.jersey().register(new LoadAllCoursesAction(jdbi));
	}

	public static void registerConsumers() {
		AceController.addConsumer("com.anfelisa.course.events.CourseCreatedEvent", CourseView.createCourse);

		AceController.addConsumer("com.anfelisa.course.events.StudentAddedToCourseEvent", StudentOfCourseView.addStudentToCourse);

		AceController.addConsumer("com.anfelisa.course.events.CourseUpdatedEvent", CourseView.updateCourse);

		AceController.addConsumer("com.anfelisa.course.events.CourseDeletedEvent", CourseView.deleteCourse);

    }
}

/*                    S.D.G.                    */
