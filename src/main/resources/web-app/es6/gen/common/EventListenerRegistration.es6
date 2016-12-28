'use strict';

class EventListenerRegistrationCommon {

	static init() {
    	ACEController.registerListener('InitOKEvent', CommonView.initLanguageInLocalStorage);
    	ACEController.registerListener('InitOKEvent', CommonView.initSchemaInLocalStorage);
    	ACEController.registerListener('ServerErrorEvent', ErrorView.renderServerError);
    	ACEController.registerListener('ErrorEvent', ErrorView.renderError);
    	ACEController.registerListener('UpdateHashEvent', CommonView.updateHash);
    	ACEController.registerListener('UserLoggedInEvent', CommonView.initUserInLocalStorage);
    	ACEController.registerListener('UserLoggedOutEvent', CommonView.removeUserFromLocalStorage);
    	ACEController.registerListener('UserLoggedOutEvent', BoxesView.hideBoxes);
    	ACEController.registerListener('RenderResultEvent', TestView.renderResult);
    	ACEController.registerListener('FieldEmptyEvent', ValidationView.fieldEmpty);
    	ACEController.registerListener('FieldNotEmptyEvent', ValidationView.fieldNotEmpty);
    	ACEController.registerListener('DisplayRemoveCourseFromUserDialogEvent', ReallyDeleteDialogView.displayRemoveCourseFromUserDialog);
    	ACEController.registerListener('DisplayDeleteBoxDialogEvent', ReallyDeleteDialogView.displayDeleteBoxDialog);
    	ACEController.registerListener('SwitchLanguageEvent', CommonView.initLanguageInLocalStorage);
    	ACEController.registerListener('RenderLoginEvent', HeaderView.renderLogin);
    	ACEController.registerListener('RenderLogoutEvent', HeaderView.renderLogout);
	}

}

EventListenerRegistrationCommon.init();

/*       S.D.G.       */
