'use strict';

class AbstractLoadPrivateCoursesSilentlyCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadPrivateCoursesSilentlyCommand");
        this.privateCoursesSilentlyLoaded = "privateCoursesSilentlyLoaded";
        this.serverError = "serverError";
        this.userNotLoggedIn = "userNotLoggedIn";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.privateCoursesSilentlyLoaded:
        	promises.push(new PrivateCoursesSilentlyLoadedEvent(this.commandData).publish());
        	break;
        case this.serverError:
        	promises.push(new ServerErrorEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LogoutAction(this.commandData)).publish());
        	break;
        case this.userNotLoggedIn:
        	promises.push(new TriggerAction(new LogoutAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
