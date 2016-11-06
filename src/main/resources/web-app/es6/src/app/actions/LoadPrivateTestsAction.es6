'use strict';

class LoadPrivateTestsAction extends AbstractLoadPrivateTestsAction {

    initActionData() {
        this.actionData.token = localStorage.token;
        this.actionData.lessonId = this.actionParam.lessonId;
    }

    releaseActionParam() {
    }
}

/*       S.D.G.       */
