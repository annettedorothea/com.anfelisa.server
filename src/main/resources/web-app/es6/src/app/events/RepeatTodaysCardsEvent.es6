'use strict';

class RepeatTodaysCardsEvent extends AbstractRepeatTodaysCardsEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
