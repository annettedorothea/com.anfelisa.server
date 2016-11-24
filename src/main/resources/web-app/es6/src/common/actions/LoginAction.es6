'use strict';

class LoginAction extends AbstractLoginAction {

    captureActionParam() {
		this.actionParam.username = $(".username").val();
		var password = $(".password").val();
		this.actionParam.password = CryptoJS.MD5(password).toString(CryptoJS.enc.Base64);
		console.log(this.actionParam.password);
    	if (localStorage.schema) {
	        this.actionParam.schema = localStorage.schema;
	    }
    	if (localStorage.role) {
	        this.actionParam.role = localStorage.role;
	    }
    	if (localStorage.language) {
	        this.actionParam.language = localStorage.language;
	    }
    	// capture user input
    }

    initActionData() {
		this.actionData.username = this.actionParam.username;
		this.actionData.password = this.actionParam.password;
    	if (this.actionParam.schema) {
    		this.actionData.schema = this.actionParam.schema;
    	}
    	if (this.actionParam.role) {
    		this.actionData.role = this.actionParam.role;
    	}
    	if (this.actionParam.language) {
    		this.actionData.language = this.actionParam.language;
    	}
    	// bind action parameters to action data
    }

    releaseActionParam() {
		$(".username").val(this.actionParam.username);
		$(".password").val(this.actionParam.password);
    	if (this.actionParam.schema) {
    		localStorage.schema = this.actionParam.schema;
    	}
    	if (this.actionParam.role) {
    		localStorage.role = this.actionParam.role;
    	}
    	if (this.actionParam.language) {
    		localStorage.language = this.actionParam.language;
    	}
    	// release action params during replay
    }
}

/*       S.D.G.       */
