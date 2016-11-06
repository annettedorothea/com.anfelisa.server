'use strict';

class StartTestAction extends AbstractStartTestAction {

    initActionData() {
        this.actionData.wordCount = (jQuery(".vocabulary")).length;;
        this.actionData.testMode = this.actionParam.testMode;
    }

}

/*       S.D.G.       */
