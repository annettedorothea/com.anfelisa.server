'use strict';

class DisplayComplexCardFinishedSuccessfullyEvent extends AbstractDisplayComplexCardFinishedSuccessfullyEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
