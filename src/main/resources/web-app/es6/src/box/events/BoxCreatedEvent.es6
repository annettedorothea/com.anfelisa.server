'use strict';

class BoxCreatedEvent extends AbstractBoxCreatedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
