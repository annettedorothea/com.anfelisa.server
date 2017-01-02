'use strict';

class CheckUsernameAction extends AbstractCheckUsernameAction {

    captureActionParam() {
    	if (localStorage.schema) {
	        this.actionParam.schema = localStorage.schema;
	    }
    	if (localStorage.language) {
	        this.actionParam.language = localStorage.language;
	    }
		this.actionParam.username = jQuery("#username").val().trim();
    	// capture user input
    }

    initActionData() {
   		this.actionData.username = this.actionParam.username;
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
		jQuery("#username").val(this.actionData.username);
    }
}

/*       S.D.G.       */
