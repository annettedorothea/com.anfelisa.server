'use strict';

class DoNothingEvent extends AbstractDoNothingEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
