'use strict';

class RenderCardForRepetitionEvent extends AbstractRenderCardForRepetitionEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
