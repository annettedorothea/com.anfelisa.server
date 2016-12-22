'use strict';

class SaveResultAction extends AbstractSaveResultAction {

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
		// capture user input
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
		var json = {};
		var allCompletionTexts = jQuery(".vocabulary");
		for (var i = 0; i < allCompletionTexts.length; i++) {
			var completionTextId = allCompletionTexts[i].id;
			var strikes = jQuery("#" + completionTextId + "_shots").children();
			var answer = "";
			for (var j = 0; j < strikes.length; j++) {
				var currentStrike = $(strikes[j]);
				if (currentStrike.hasClass("strike")) {
					answer += "1";
				} else {
					answer += "0";
				}
			}
			json["" + completionTextId] = answer;
		}

		this.actionData.json = JSON.stringify(json);
		var hash = window.location.hash.substring(1);
		var hashes = hash.split("/");
		this.actionData.testId = Number(hashes[hashes.length-1]);
		if (allCompletionTexts.length > 0) {
			this.actionData.points = Vocabulary.testState.points;
			this.actionData.maxPoints = Vocabulary.testState.maxPoints;
		} else {
			this.actionData.points = this.actionParam.points;
			this.actionData.maxPoints = this.actionParam.maxPoints;
		}
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
