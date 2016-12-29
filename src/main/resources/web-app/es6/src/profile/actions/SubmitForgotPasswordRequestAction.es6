'use strict';

class SubmitForgotPasswordRequestAction extends AbstractSubmitForgotPasswordRequestAction {

    captureActionParam() {
    	if (localStorage.schema) {
	        this.actionParam.schema = localStorage.schema;
	    }
    	if (localStorage.language) {
	        this.actionParam.language = localStorage.language;
	    }
		this.actionParam.username = jQuery("#username").val().trim();
    }

    initActionData() {
    	if (this.actionParam.schema) {
    		this.actionData.schema = this.actionParam.schema;
    	}
    	if (this.actionParam.language) {
    		this.actionData.language = this.actionParam.language;
    	}
		this.actionData.username = this.actionParam.username;
    }

    releaseActionParam() {
    	if (this.actionParam.schema) {
    		localStorage.schema = this.actionParam.schema;
    	}
    	if (this.actionParam.language) {
    		localStorage.language = this.actionParam.language;
    	}
		jQuery("#username").val(this.actionData.username);
    }
}

/*       S.D.G.       */
