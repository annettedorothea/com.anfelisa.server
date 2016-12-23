'use strict';

class EventListenerRegistrationProfile {

	static init() {
    	ACEController.registerListener('UserInfoLoadedEvent', UserInfoView.renderUserInfo);
	}

}

EventListenerRegistrationProfile.init();

/*       S.D.G.       */
