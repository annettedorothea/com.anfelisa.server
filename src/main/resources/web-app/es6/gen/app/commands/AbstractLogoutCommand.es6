'use strict';

class AbstractLogoutCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LogoutCommand");
        this.successfulLogout = "successfulLogout";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.successfulLogout:
        	promises.push(new UserIsNotLoggedInEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LoadPublicCoursesAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
