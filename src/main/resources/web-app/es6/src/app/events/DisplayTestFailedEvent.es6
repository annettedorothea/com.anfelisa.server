'use strict';

class DisplayTestFailedEvent extends AbstractDisplayTestFailedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
