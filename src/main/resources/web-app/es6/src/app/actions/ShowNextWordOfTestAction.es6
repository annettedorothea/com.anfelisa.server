'use strict';

class ShowNextWordOfTestAction extends AbstractShowNextWordOfTestAction {

    captureActionParam() {
        this.actionParam.nextRandomIndex = App.vocubularyView.testState.nextRandomIndex();
    }

    initActionData() {
        this.actionData.nextRandomIndex = this.actionParam.nextRandomIndex;
        this.actionData.wordCount = this.actionParam.wordCount;
        this.actionData.testMode = this.actionParam.testMode;
        this.actionData.wordCount = this.actionParam.wordCount;
    }

}

/*       S.D.G.       */
