'use strict';

class InitAction extends AbstractInitAction {

    captureActionParam() {
    	if (localStorage.username) {
	        this.actionParam.username = localStorage.username;
	    }
    	if (localStorage.password) {
	        this.actionParam.password = localStorage.password;
	    }
    	if (localStorage.schema) {
	        this.actionParam.schema = localStorage.schema;
	    } else {
			this.actionParam.schema = "anfelisa";
		}
    	if (localStorage.role) {
	        this.actionParam.role = localStorage.role;
	    }
    	if (localStorage.language) {
	        this.actionParam.language = localStorage.language;
	    } else {
			this.actionParam.language = "de";
		}
		this.actionParam.hash = window.location.hash.substring(1);
    }

    initActionData() {
    	if (this.actionParam.username) {
    		this.actionData.username = this.actionParam.username;
    	}
    	if (this.actionParam.password) {
    		this.actionData.password = this.actionParam.password;
    	}
    	if (this.actionParam.role) {
    		this.actionData.role = this.actionParam.role;
    	}
		this.actionData.schema = this.actionParam.schema;
		this.actionData.language = this.actionParam.language;
		this.actionData.hash = this.actionParam.hash;
    }

    releaseActionParam() {
    	if (this.actionParam.username) {
    		localStorage.username = this.actionParam.username;
    	}
    	if (this.actionParam.password) {
    		localStorage.password = this.actionParam.password;
    	}
    	if (this.actionParam.role) {
    		localStorage.role = this.actionParam.role;
    	}
   		localStorage.schema = this.actionParam.schema;
   		localStorage.language = this.actionParam.language;
		window.location.hash = this.actionParam.hash;
    }
}

/*       S.D.G.       */
