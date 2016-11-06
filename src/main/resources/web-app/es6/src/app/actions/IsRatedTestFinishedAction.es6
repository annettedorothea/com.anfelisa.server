'use strict';

class IsRatedTestFinishedAction extends AbstractIsRatedTestFinishedAction {

    initActionData() {
        this.actionData.strikeCount = this.actionParam.strikeCount;
        this.actionData.points = this.actionParam.points;
        this.actionData.wordCount = this.actionParam.wordCount;
    }

}

/*       S.D.G.       */
