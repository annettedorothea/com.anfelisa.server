'use strict';

class CheckIfComplexCardIsFinishedAction extends AbstractCheckIfComplexCardIsFinishedAction {

    initActionData() {
        this.actionData.isFinished = !$(".word").hasClass("hiddenWord");
    }

}

/*       S.D.G.       */
