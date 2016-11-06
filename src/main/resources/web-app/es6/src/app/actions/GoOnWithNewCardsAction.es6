'use strict';

class GoOnWithNewCardsAction extends AbstractGoOnWithNewCardsAction {

    initActionData() {
        this.actionData.token = localStorage.token;
        this.actionData.boxId = App.cardView.currentBoxId;
    }

    releaseActionParam() {
    }
}

/*       S.D.G.       */
