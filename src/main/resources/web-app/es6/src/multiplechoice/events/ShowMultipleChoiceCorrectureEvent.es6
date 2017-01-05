'use strict';

class ShowMultipleChoiceCorrectureEvent extends AbstractShowMultipleChoiceCorrectureEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
