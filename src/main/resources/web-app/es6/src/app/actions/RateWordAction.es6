'use strict';

class RateWordAction extends AbstractRateWordAction {

    initActionData() {
        this.actionData.knewIt = this.actionParam.knewIt;
        this.actionData.id = jQuery(".active").attr("id");
        this.actionData.wordCount = App.vocubularyView.testState.wordCount;
        this.actionData.strikeCount = App.vocubularyView.testState.strikeCount;
        this.actionData.points = App.vocubularyView.testState.points;
        this.actionData.strikesOfWord = jQuery("#" + this.actionData.id + "_shots").children(".strike").length;
    }

}

/*       S.D.G.       */
