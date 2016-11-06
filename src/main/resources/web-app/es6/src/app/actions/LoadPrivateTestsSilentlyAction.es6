'use strict';

class LoadPrivateTestsSilentlyAction extends AbstractLoadPrivateTestsSilentlyAction {

    initActionData() {
        this.actionData.token = localStorage.token;
        this.actionData.lessonId = this.actionParam.lessonId;
    }

    releaseActionParam() {
    }
}

/*       S.D.G.       */
