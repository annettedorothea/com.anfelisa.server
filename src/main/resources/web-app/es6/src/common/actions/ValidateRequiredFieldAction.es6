'use strict';

class ValidateRequiredFieldAction extends AbstractValidateRequiredFieldAction {

    captureActionParam() {
    	if (localStorage.username) {
	        this.actionParam.username = localStorage.username;
	    }
    	if (localStorage.password) {
	        this.actionParam.password = localStorage.password;
	    }
    	if (localStorage.schema) {
	        this.actionParam.schema = localStorage.schema;
	    }
    	if (localStorage.role) {
	        this.actionParam.role = localStorage.role;
	    }
    	if (localStorage.language) {
	        this.actionParam.language = localStorage.language;
	    }
		this.actionParam.value = $("#" + this.actionParam.id).val();
    }

    initActionData() {
    	if (this.actionParam.username) {
    		this.actionData.username = this.actionParam.username;
    	}
    	if (this.actionParam.password) {
    		this.actionData.password = this.actionParam.password;
    	}
    	if (this.actionParam.schema) {
    		this.actionData.schema = this.actionParam.schema;
    	}
    	if (this.actionParam.role) {
    		this.actionData.role = this.actionParam.role;
    	}
    	if (this.actionParam.language) {
    		this.actionData.language = this.actionParam.language;
    	}
		this.actionData.id = this.actionParam.id;
		this.actionData.value = this.actionParam.value;
    }

    releaseActionParam() {
    	if (this.actionParam.username) {
    		localStorage.username = this.actionParam.username;
    	}
    	if (this.actionParam.password) {
    		localStorage.password = this.actionParam.password;
    	}
    	if (this.actionParam.schema) {
    		localStorage.schema = this.actionParam.schema;
    	}
    	if (this.actionParam.role) {
    		localStorage.role = this.actionParam.role;
    	}
    	if (this.actionParam.language) {
    		localStorage.language = this.actionParam.language;
    	}
		$("#" + this.actionParam.id + "").val(this.actionParam.value);
    }
}

/*       S.D.G.       */
