'use strict';

class SubmitNewPasswordAction extends AbstractSubmitNewPasswordAction {

    captureActionParam() {
    	if (localStorage.schema) {
	        this.actionParam.schema = localStorage.schema;
	    }
    	if (localStorage.language) {
	        this.actionParam.language = localStorage.language;
	    }
		this.actionParam.username = jQuery("#username").val().trim();
		this.actionParam.password = jQuery("#oldPassword").val().trim();
		this.actionParam.newPassword = CryptoJS.MD5(jQuery("#password").val().trim()).toString(CryptoJS.enc.Base64);
		this.actionParam.passwordRepetition = CryptoJS.MD5(jQuery("#passwordRepetition").val().trim()).toString(CryptoJS.enc.Base64);
    }

    initActionData() {
		this.actionData.username = this.actionParam.username;
		this.actionData.password = this.actionParam.password;
		this.actionData.newPassword = this.actionParam.newPassword;
		this.actionData.passwordRepetition = this.actionParam.passwordRepetition;
    	if (this.actionParam.schema) {
    		this.actionData.schema = this.actionParam.schema;
    	}
    	if (this.actionParam.language) {
    		this.actionData.language = this.actionParam.language;
    	}
    	// bind action parameters to action data
    }

    releaseActionParam() {
    	if (this.actionParam.schema) {
    		localStorage.schema = this.actionParam.schema;
    	}
    	if (this.actionParam.language) {
    		localStorage.language = this.actionParam.language;
    	}
    }
}

/*       S.D.G.       */
