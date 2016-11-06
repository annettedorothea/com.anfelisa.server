'use strict';

class SaveResultAction extends AbstractSaveResultAction {

    initActionData() {
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

        this.actionData.json = json;
        this.actionData.testId = App.commonView.selection.selectedTest;
        if (allCompletionTexts.length > 0) {
            this.actionData.points = App.vocubularyView.testState.points;
            this.actionData.maxPoints = App.vocubularyView.testState.maxPoints;
        } else {
            this.actionData.points = App.cardView.testState.points;
            this.actionData.maxPoints = App.cardView.testState.maxPoints;
        }
        this.actionData.token = localStorage.token;
    }

}

/*       S.D.G.       */
