'use strict';

class ResultLoadedEvent extends AbstractResultLoadedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
