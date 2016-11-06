'use strict';

class LoadResultAction extends AbstractLoadResultAction {

    initActionData() {
        this.actionData.token = localStorage.token;
        this.actionData.resultId = this.actionParam.resultId;
    }

    releaseActionParam() {
    }
}

/*       S.D.G.       */
