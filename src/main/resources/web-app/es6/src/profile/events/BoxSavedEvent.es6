'use strict';

class BoxSavedEvent extends AbstractBoxSavedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
