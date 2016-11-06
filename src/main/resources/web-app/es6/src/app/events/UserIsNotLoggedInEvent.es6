'use strict';

class UserIsNotLoggedInEvent extends AbstractUserIsNotLoggedInEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
