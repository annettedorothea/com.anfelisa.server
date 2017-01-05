'use strict';

class RepeatComplexCardAction extends AbstractRepeatComplexCardAction {

    captureActionParam() {
		this.actionParam.hash = window.location.hash.substring(1);
    }

    initActionData() {
		this.actionData.hash = this.actionParam.hash;
    }

    releaseActionParam() {
		window.location.hash = this.actionParam.hash;
    }
}

/*       S.D.G.       */
