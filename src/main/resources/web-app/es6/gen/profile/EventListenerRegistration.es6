'use strict';

class EventListenerRegistrationProfile {

	static init() {
    	ACEController.registerListener('UserInfoLoadedEvent', UserInfoView.renderUserInfo);
    	ACEController.registerListener('CoursesLoadedEvent', UserInfoView.renderCourseSelection);
	}

}

EventListenerRegistrationProfile.init();

/*       S.D.G.       */
