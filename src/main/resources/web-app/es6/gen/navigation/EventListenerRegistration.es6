'use strict';

class EventListenerRegistrationNavigation {

	static init() {
    	ACEController.registerListener('PublicCoursesReadEvent', NavigationView.renderPublicCourses);
    	ACEController.registerListener('PublicCoursesReadEvent', ContentView.renderPublicCourses);
    	ACEController.registerListener('PublicCoursesReadEvent', BreadcrumbsView.renderPublicCoursesBreadcrumbs);
	}

}

/*       S.D.G.       */
