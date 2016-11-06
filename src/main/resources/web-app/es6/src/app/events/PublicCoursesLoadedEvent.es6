'use strict';

class PublicCoursesLoadedEvent extends AbstractPublicCoursesLoadedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
