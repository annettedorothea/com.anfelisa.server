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
		this.actionParam.hash = window.location.hash.substring(1);
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

		if ($("#questionOverviewList i").length > 0) {
			this.actionParam.maxPoints = $("#questionOverviewList i").length;
			var correctAnswers = $("#questionOverviewList i.correct").length;
			var falseAnswers = $("#questionOverviewList i.false").length;
			this.actionParam.points = correctAnswers - falseAnswers;
			if (this.actionParam.points < 0) {
				this.actionParam.points = 0;
			}

			for (var i = 1; i <= this.actionParam.maxPoints; i++) {
				var result = "";
				$("#" + i + " i").each(function() {
					if ($(this).hasClass("correct")) {
						result += "1";
					} else if ($(this).hasClass("false")) {
						result += "2";
					} else {
						result += "0";
					}
				});
				json[i] = result;
			}
            //json["points"] = points;
            //json["maxPoints"] = maxPoints;
		}




		if (allCompletionTexts.length > 0) {
			this.actionData.points = Vocabulary.testState.points;
			this.actionData.maxPoints = Vocabulary.testState.maxPoints;
		} else {
			this.actionData.points = this.actionParam.points;
			this.actionData.maxPoints = this.actionParam.maxPoints;
		}

		this.actionData.json = JSON.stringify(json);
		var hashes = this.actionParam.hash.split("/");
		this.actionData.testId = Number(hashes[hashes.length-1]);
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
