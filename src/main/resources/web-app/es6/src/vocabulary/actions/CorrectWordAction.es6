'use strict';

class CorrectWordAction extends AbstractCorrectWordAction {

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
		this.actionParam.answer = jQuery(".active").val().trim();
		this.actionParam.id = jQuery(".active").attr("id");
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
		this.actionData.answer = this.actionParam.answer;
		this.actionData.id = this.actionParam.id;
		this.actionData.solution = jQuery(".active").next().html();
		this.actionData.wordCount = Vocabulary.testState.wordCount;
		this.actionData.strikeCount = Vocabulary.testState.strikeCount;
		this.actionData.points = Vocabulary.testState.points;
		this.actionData.strikesOfWord = jQuery("#" + this.actionData.id + "_shots").children(".strike").length;
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
    	// release action params during replay
    }
}

/*       S.D.G.       */
