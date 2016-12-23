'use strict';

class SaveProfileAction extends AbstractSaveProfileAction {

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
		this.actionParam.name = jQuery("#name").val().trim();
		this.actionParam.prename = jQuery("#prename").val().trim();
		this.actionParam.email = jQuery("#email").val().trim();
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
		this.actionData.name = this.actionParam.name;
		this.actionData.prename = this.actionParam.prename;
		this.actionData.email = this.actionParam.email;
		this.actionData.username = this.actionParam.username;
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
		jQuery("#name").val(this.actionData.name);
		jQuery("#prename").val(this.actionData.prename);
		jQuery("#email").val(this.actionData.email);
    }
}

/*       S.D.G.       */
