'use strict';

class PublicLessonsLoadedEvent extends AbstractPublicLessonsLoadedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
