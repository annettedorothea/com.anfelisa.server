'use strict';

class LoginFailedEvent extends AbstractLoginFailedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
