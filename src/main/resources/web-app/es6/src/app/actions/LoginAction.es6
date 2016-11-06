'use strict';

class LoginAction extends AbstractLoginAction {

    captureActionParam() {
        this.actionParam.username = $(".username").val();
        this.actionParam.password = $(".password").val();
    }

    initActionData() {
        this.actionData.username = this.actionParam.username;
        this.actionData.password = this.actionParam.password;
    }

    releaseActionParam() {
        $(".username").val(this.actionParam.username);
        $(".password").val(this.actionParam.password);
    }
}

/*       S.D.G.       */
