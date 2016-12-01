'use strict';

class EventListenerRegistrationNavigation {

	static init() {
    	ACEController.registerListener('PublicCoursesReadEvent', NavigationView.renderPublicCourses);
    	ACEController.registerListener('PublicCoursesReadEvent', ContentView.renderPublicCourses);
    	ACEController.registerListener('PublicCoursesReadEvent', BreadcrumbsView.renderPublicCoursesBreadcrumbs);
    	ACEController.registerListener('PublicCoursesReadEvent', HeaderView.renderLogin);
    	ACEController.registerListener('PublicLessonsReadEvent', NavigationView.renderPublicLessons);
    	ACEController.registerListener('PublicLessonsReadEvent', ContentView.renderPublicLessons);
    	ACEController.registerListener('PublicLessonsReadEvent', BreadcrumbsView.renderPublicLessonsBreadcrumbs);
    	ACEController.registerListener('PublicLessonsReadEvent', HeaderView.renderLogin);
    	ACEController.registerListener('PublicTestsReadEvent', NavigationView.renderPublicTests);
    	ACEController.registerListener('PublicTestsReadEvent', ContentView.renderPublicTests);
    	ACEController.registerListener('PublicTestsReadEvent', BreadcrumbsView.renderPublicTestsBreadcrumbs);
    	ACEController.registerListener('PublicTestsReadEvent', HeaderView.renderLogin);
    	ACEController.registerListener('PublicTestReadEvent', NavigationView.renderPublicTest);
    	ACEController.registerListener('PublicTestReadEvent', ContentView.renderPublicTest);
    	ACEController.registerListener('PublicTestReadEvent', BreadcrumbsView.renderPublicTestsBreadcrumbs);
    	ACEController.registerListener('PublicTestReadEvent', HeaderView.renderLogin);
    	ACEController.registerListener('PrivateCoursesReadEvent', NavigationView.renderPrivateCourses);
    	ACEController.registerListener('PrivateCoursesReadEvent', ContentView.renderPrivateCourses);
    	ACEController.registerListener('PrivateCoursesReadEvent', BreadcrumbsView.renderPrivateCoursesBreadcrumbs);
    	ACEController.registerListener('PrivateCoursesReadEvent', HeaderView.renderLogout);
    	ACEController.registerListener('PrivateLessonsReadEvent', NavigationView.renderPrivateLessons);
    	ACEController.registerListener('PrivateLessonsReadEvent', ContentView.renderPrivateLessons);
    	ACEController.registerListener('PrivateLessonsReadEvent', BreadcrumbsView.renderPrivateLessonsBreadcrumbs);
    	ACEController.registerListener('PrivateLessonsReadEvent', HeaderView.renderLogout);
    	ACEController.registerListener('PrivateTestsReadEvent', NavigationView.renderPrivateTests);
    	ACEController.registerListener('PrivateTestsReadEvent', ContentView.renderPrivateTests);
    	ACEController.registerListener('PrivateTestsReadEvent', BreadcrumbsView.renderPrivateTestsBreadcrumbs);
    	ACEController.registerListener('PrivateTestsReadEvent', HeaderView.renderLogout);
    	ACEController.registerListener('PrivateTestReadEvent', NavigationView.renderPrivateTest);
    	ACEController.registerListener('PrivateTestReadEvent', ContentView.renderPrivateTest);
    	ACEController.registerListener('PrivateTestReadEvent', BreadcrumbsView.renderPrivateTestsBreadcrumbs);
    	ACEController.registerListener('PrivateTestReadEvent', HeaderView.renderLogout);
    	ACEController.registerListener('ResultReadEvent', NavigationView.renderPrivateTest);
    	ACEController.registerListener('ResultReadEvent', ContentView.renderPrivateTest);
    	ACEController.registerListener('ResultReadEvent', BreadcrumbsView.renderPrivateTestsBreadcrumbs);
    	ACEController.registerListener('ResultReadEvent', HeaderView.renderLogout);
    	ACEController.registerListener('ResultReadEvent', ContentView.renderResult);
    	ACEController.registerListener('StatisticsReadEvent', ContentView.renderStatistics);
    	ACEController.registerListener('BoxesReadEvent', BoxesView.renderBoxes);
    	ACEController.registerListener('NextCardReadEvent', ContentView.renderCard);
	}

}

/*       S.D.G.       */
