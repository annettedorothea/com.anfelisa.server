'use strict';

class LoadTestOfResultAction extends AbstractLoadTestOfResultAction {

    initActionData() {
        this.actionData.token = localStorage.token;
        this.actionData.resultId = this.actionParam.resultId;
    }

    releaseActionParam() {
    }
}

/*       S.D.G.       */
