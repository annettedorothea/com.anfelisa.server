'use strict';

class EventListenerRegistrationProfile {

	static init() {
    	ACEController.registerListener('UserInfoLoadedEvent', UserInfoView.renderUserInfo);
    	ACEController.registerListener('CoursesLoadedEvent', UserInfoView.renderCourseSelection);
    	ACEController.registerListener('RenderBoxEvent', UserInfoView.renderBox);
    	ACEController.registerListener('RenderCourseToBoxEvent', UserInfoView.renderCourseToBox);
    	ACEController.registerListener('RenderChangePasswordEvent', UserInfoView.renderPasswordChange);
    	ACEController.registerListener('PasswordsOKEvent', UserInfoView.passwordOK);
    	ACEController.registerListener('PasswordsMismatchEvent', UserInfoView.passwordMismatch);
	}

}

EventListenerRegistrationProfile.init();

/*       S.D.G.       */
