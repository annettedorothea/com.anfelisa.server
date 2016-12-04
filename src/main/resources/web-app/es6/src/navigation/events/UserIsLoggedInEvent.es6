'use strict';

class UserIsLoggedInEvent extends AbstractUserIsLoggedInEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
