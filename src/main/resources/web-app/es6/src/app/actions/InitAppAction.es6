'use strict';

class InitAppAction extends AbstractInitAppAction {

    captureActionParam() {
        this.actionParam.hash = window.location.hash.substring(1);
        this.actionParam.username = localStorage.username;
        this.actionParam.password = localStorage.password;
    }

    initActionData() {
        this.actionData.hash = this.actionParam.hash;
        this.actionData.username = this.actionParam.username;
        this.actionData.password = this.actionParam.password;
    }

    releaseActionParam() {
        localStorage.username = this.actionParam.username;
        localStorage.password = this.actionParam.password;
        window.location.hash = this.actionParam.hash;
    }
}

/*       S.D.G.       */
