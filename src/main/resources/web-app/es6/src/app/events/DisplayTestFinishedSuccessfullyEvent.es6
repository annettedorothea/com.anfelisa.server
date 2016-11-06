'use strict';

class DisplayTestFinishedSuccessfullyEvent extends AbstractDisplayTestFinishedSuccessfullyEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
