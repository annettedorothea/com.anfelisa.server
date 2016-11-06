'use strict';

class BoxesSilentlyLoadedEvent extends AbstractBoxesSilentlyLoadedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
