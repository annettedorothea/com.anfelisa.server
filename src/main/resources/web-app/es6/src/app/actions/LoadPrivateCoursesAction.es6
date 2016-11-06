'use strict';

class LoadPrivateCoursesAction extends AbstractLoadPrivateCoursesAction {

    initActionData() {
        this.actionData.token = localStorage.token;
    }

    releaseActionParam() {
    }
}

/*       S.D.G.       */
