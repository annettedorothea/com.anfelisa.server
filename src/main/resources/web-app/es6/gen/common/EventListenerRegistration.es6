'use strict';

class EventListenerRegistrationCommon {

	static init() {
    	ACEController.registerListener('InitOKEvent', CommonView.initLanguageInLocalStorage);
    	ACEController.registerListener('InitOKEvent', CommonView.initSchemaInLocalStorage);
    	ACEController.registerListener('ServerErrorEvent', ErrorView.renderServerError);
    	ACEController.registerListener('ErrorEvent', ErrorView.renderError);
    	ACEController.registerListener('UpdateHashEvent', CommonView.updateHash);
	}

}

/*       S.D.G.       */
