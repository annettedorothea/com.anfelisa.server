'use strict';

class CorrectWordAction extends AbstractCorrectWordAction {

    captureActionParam() {
        this.actionParam.answer = jQuery(".active").val().trim();
        this.actionParam.id = jQuery(".active").attr("id");
    }

    initActionData() {
        this.actionData.answer = this.actionParam.answer;
        this.actionData.id = this.actionParam.id;
        this.actionData.solution = jQuery(".active").next().html();
        this.actionData.wordCount = App.vocubularyView.testState.wordCount;
        this.actionData.strikeCount = App.vocubularyView.testState.strikeCount;
        this.actionData.points = App.vocubularyView.testState.points;
        this.actionData.strikesOfWord = jQuery("#" + this.actionData.id + "_shots").children(".strike").length;
    }

    releaseActionParam() {
        jQuery("#" + this.actionParam.id).val(this.actionParam.answer);
    }
}

/*       S.D.G.       */
