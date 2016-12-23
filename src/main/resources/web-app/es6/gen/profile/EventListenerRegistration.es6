'use strict';

class EventListenerRegistrationProfile {

	static init() {
    	ACEController.registerListener('UserInfoLoadedEvent', UserInfoView.renderUserInfo);
	}

}

/*       S.D.G.       */
