'use strict';

class PrivateTestsSilentlyLoadedEvent extends AbstractPrivateTestsSilentlyLoadedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
