'use strict';

class PrivateCoursesLoadedEvent extends AbstractPrivateCoursesLoadedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
