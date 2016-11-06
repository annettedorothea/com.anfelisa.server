'use strict';

class IsBoxFinishedAction extends AbstractIsBoxFinishedAction {

    initActionData() {
        this.actionData.boxId = App.cardView.currentBoxId;
        this.actionData.index = App.cardView.boxRepetitionState.index;
        this.actionData.length = App.cardView.boxRepetitionState.cards.length;
    }

}

/*       S.D.G.       */
