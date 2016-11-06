'use strict';

class LoadNextCardAction extends AbstractLoadNextCardAction {

    initActionData() {
        this.actionData.boxId = this.actionParam.boxId;
        this.actionData.token = localStorage.token;
    }

}

/*       S.D.G.       */
