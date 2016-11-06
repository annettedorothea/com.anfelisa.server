'use strict';

class LoadBoxesSilentlyAction extends AbstractLoadBoxesSilentlyAction {

    initActionData() {
        this.actionData.token = localStorage.token;
        this.actionData.selectedBoxId = this.actionParam.boxId;
    }

}

/*       S.D.G.       */
