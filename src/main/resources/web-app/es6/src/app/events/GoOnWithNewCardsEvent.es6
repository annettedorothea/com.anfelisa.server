'use strict';

class GoOnWithNewCardsEvent extends AbstractGoOnWithNewCardsEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
