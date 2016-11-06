'use strict';

class StartBoxAction extends AbstractStartBoxAction {

    initActionData() {
        this.actionData.token = localStorage.token;
        this.actionData.boxId = this.actionParam.boxId;
    }

}

/*       S.D.G.       */
