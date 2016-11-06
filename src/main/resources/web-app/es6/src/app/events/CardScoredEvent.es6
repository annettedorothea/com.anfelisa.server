'use strict';

class CardScoredEvent extends AbstractCardScoredEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
