'use strict';

class RepeatComplexCardEvent extends AbstractRepeatComplexCardEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
