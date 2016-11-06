'use strict';

class AutoLoginAction extends AbstractAutoLoginAction {

    captureActionParam() {
        this.actionParam.username = localStorage.username;
        this.actionParam.password = localStorage.password;
    }

    initActionData() {
        this.actionData.username = this.actionParam.username;
        this.actionData.password = this.actionParam.password;
    }

    releaseActionParam() {
        localStorage.username = this.actionParam.username;
        localStorage.password = this.actionParam.password;
    }

}

/*       S.D.G.       */
