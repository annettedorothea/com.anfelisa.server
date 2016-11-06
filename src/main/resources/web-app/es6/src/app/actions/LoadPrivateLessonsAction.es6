'use strict';

class LoadPrivateLessonsAction extends AbstractLoadPrivateLessonsAction {

    initActionData() {
        this.actionData.token = localStorage.token;
        this.actionData.courseId = this.actionParam.courseId;
    }

    releaseActionParam() {
    }
}

/*       S.D.G.       */
