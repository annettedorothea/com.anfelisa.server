'use strict';

class EventListenerRegistrationNavigation {

	static init() {
    	ACEController.registerListener('PublicCoursesReadEvent', NavigationView.renderPublicCourses);
    	ACEController.registerListener('PublicCoursesReadEvent', ContentView.renderPublicCourses);
    	ACEController.registerListener('PublicCoursesReadEvent', BreadcrumbsView.renderPublicCoursesBreadcrumbs);
    	ACEController.registerListener('PublicLessonsReadEvent', NavigationView.renderPublicLessons);
    	ACEController.registerListener('PublicLessonsReadEvent', ContentView.renderPublicLessons);
    	ACEController.registerListener('PublicLessonsReadEvent', BreadcrumbsView.renderPublicLessonsBreadcrumbs);
    	ACEController.registerListener('PublicTestsReadEvent', NavigationView.renderPublicTests);
    	ACEController.registerListener('PublicTestsReadEvent', ContentView.renderPublicTests);
    	ACEController.registerListener('PublicTestsReadEvent', BreadcrumbsView.renderPublicTestsBreadcrumbs);
    	ACEController.registerListener('PublicTestReadEvent', NavigationView.renderPublicTest);
    	ACEController.registerListener('PublicTestReadEvent', ContentView.renderPublicTest);
    	ACEController.registerListener('PublicTestReadEvent', BreadcrumbsView.renderPublicTestsBreadcrumbs);
	}

}

/*       S.D.G.       */
