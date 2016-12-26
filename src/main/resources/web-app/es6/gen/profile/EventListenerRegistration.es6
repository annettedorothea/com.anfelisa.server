'use strict';

class EventListenerRegistrationProfile {

	static init() {
    	ACEController.registerListener('UserInfoLoadedEvent', UserInfoView.renderUserInfo);
    	ACEController.registerListener('CoursesLoadedEvent', UserInfoView.renderCourseSelection);
    	ACEController.registerListener('RenderBoxEvent', UserInfoView.renderBox);
    	ACEController.registerListener('RenderCourseToBoxEvent', UserInfoView.renderCourseToBox);
	}

}

EventListenerRegistrationProfile.init();

/*       S.D.G.       */
