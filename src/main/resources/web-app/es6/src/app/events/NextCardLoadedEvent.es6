'use strict';

class NextCardLoadedEvent extends AbstractNextCardLoadedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
