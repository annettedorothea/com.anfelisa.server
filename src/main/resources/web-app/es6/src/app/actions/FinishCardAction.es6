'use strict';

class FinishCardAction extends AbstractFinishCardAction {

    initActionData() {
        this.actionData.token = localStorage.token;
        this.actionData.points = this.actionParam.points;
        this.actionData.maxPoints = this.actionParam.maxPoints;
    }

    releaseActionParam() {
    }
}

/*       S.D.G.       */
