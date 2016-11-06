'use strict';

class LoadPrivateTestAction extends AbstractLoadPrivateTestAction {

    initActionData() {
        this.actionData.token = localStorage.token;
        this.actionData.testId = this.actionParam.testId;
    }

    releaseActionParam() {
    }
}

/*       S.D.G.       */
