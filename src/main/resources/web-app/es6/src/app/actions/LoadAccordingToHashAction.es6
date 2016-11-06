'use strict';

class LoadAccordingToHashAction extends AbstractLoadAccordingToHashAction {

    captureActionParam() {
        this.actionParam.hash = window.location.hash.substring(1);
    }

    initActionData() {
        this.actionData.hash = this.actionParam.hash;
        this.actionData.userIsLoggedIn = localStorage.token !== undefined;
    }

    releaseActionParam() {
        window.location.hash = this.actionParam.hash;
    }

}

/*       S.D.G.       */
