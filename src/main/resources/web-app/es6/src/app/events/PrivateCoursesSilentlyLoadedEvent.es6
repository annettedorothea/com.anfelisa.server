'use strict';

class PrivateCoursesSilentlyLoadedEvent extends AbstractPrivateCoursesSilentlyLoadedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
