'use strict';

class PublicTestLoadedEvent extends AbstractPublicTestLoadedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
