'use strict';

class RepeatTodaysCardsAction extends AbstractRepeatTodaysCardsAction {

    initActionData() {
        this.actionData.boxId = App.cardView.currentBoxId;
        this.actionData.token = localStorage.token;
    }

    releaseActionParam() {
    }
}

/*       S.D.G.       */
