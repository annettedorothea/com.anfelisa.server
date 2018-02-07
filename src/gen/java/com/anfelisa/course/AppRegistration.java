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

	public static void registerResources(Environment environment, DBI jdbi, DBI jdbiTimeline) {
		environment.jersey().register(new CreateCourseAction(jdbi, jdbiTimeline));
		environment.jersey().register(new AddStudentToCourseAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadPublicCoursesAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadPrivateCoursesAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadStatisticsAction(jdbi, jdbiTimeline));
		environment.jersey().register(new GetCourseAction(jdbi, jdbiTimeline));
		environment.jersey().register(new UpdateCourseAction(jdbi, jdbiTimeline));
		environment.jersey().register(new DeleteCourseAction(jdbi, jdbiTimeline));
		environment.jersey().register(new LoadAllCoursesAction(jdbi, jdbiTimeline));
	}

	public static void registerConsumers() {
			AceController.addConsumer("com.anfelisa.course.events.CourseCreatedEvent", CourseView.createCourse);
			AceController.addConsumer("com.anfelisa.course.events.StudentAddedToCourseEvent", StudentOfCourseView.addStudentToCourse);
			AceController.addConsumer("com.anfelisa.course.events.CourseUpdatedEvent", CourseView.updateCourse);
			AceController.addConsumer("com.anfelisa.course.events.CourseDeletedEvent", CourseView.deleteCourse);
    }
}

/*                    S.D.G.                    */
