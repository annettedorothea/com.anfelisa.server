'use strict';

class OpenNewPasswordAction extends AbstractOpenNewPasswordAction {

    captureActionParam() {
    	if (localStorage.schema) {
	        this.actionParam.schema = localStorage.schema;
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
    	// release action params during replay
    }
}

/*       S.D.G.       */
