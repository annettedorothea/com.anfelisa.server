'use strict';

class PrivateLessonsLoadedEvent extends AbstractPrivateLessonsLoadedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
