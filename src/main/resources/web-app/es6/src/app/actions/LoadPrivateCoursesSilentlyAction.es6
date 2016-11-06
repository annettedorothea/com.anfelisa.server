'use strict';

class LoadPrivateCoursesSilentlyAction extends AbstractLoadPrivateCoursesSilentlyAction {

    initActionData() {
        this.actionData.token = localStorage.token;
    }

    releaseActionParam() {
    }
}

/*       S.D.G.       */
