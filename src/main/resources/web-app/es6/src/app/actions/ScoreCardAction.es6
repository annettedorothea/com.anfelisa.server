'use strict';

class ScoreCardAction extends AbstractScoreCardAction {

    initActionData() {
        this.actionData.boxId = App.cardView.currentBoxId;
        this.actionData.id = App.cardView.currentCardId;
        this.actionData.quality = this.actionParam.quality;
        this.actionData.token = localStorage.token;
    }

}

/*       S.D.G.       */
